package com.minibus.moment.controller;

import com.minibus.moment.dto.user.SignUp;
import com.minibus.moment.exception.MinibusErrorCode;
import com.minibus.moment.exception.MinibusException;
import com.minibus.moment.service.MailService;
import com.minibus.moment.service.Token;
import com.minibus.moment.service.JwtTokenProvider;
import com.minibus.moment.domain.user.User;
import com.minibus.moment.domain.user.UserRepository;
import com.minibus.moment.dto.user.Login;
import com.minibus.moment.dto.user.UserInfoDto;
import com.minibus.moment.dto.user.UserRequest;
import com.minibus.moment.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final UserService userService;

    private final MailService mailService;

    @PostMapping("/signUp")
    public String singUp(@RequestBody SignUp.Request request) {
        userService.singUp(request);
        return "Success!";
    }

    // email로 요청 받으면 토큰을 발급
    @PostMapping("/signIn")
    public Login.Response login(@RequestBody Login.Request request, HttpServletResponse response) {

        User user = userService.getUser(request.getEmail());
        if(!user.getPassword().equals(request.getPassword())){
            throw new MinibusException(MinibusErrorCode.USER_NOT_FOUND);
        }
        Token token = jwtTokenProvider.generateToken(user.getEmail(), "USER");
        Cookie cookie = new Cookie("Auth", token.getToken());
        cookie.setMaxAge(3600);
        response.addCookie(cookie);

        return Login.Response.of(user);
    }

    @GetMapping("/login/{userId}")
    public Login.Response login(@PathVariable Long userId, HttpServletResponse response) {
        User user = userService.login(userId);

        Token token = jwtTokenProvider.generateToken(user.getEmail(), "USER");
        Cookie cookie = new Cookie("Auth", token.getToken());
        cookie.setMaxAge(3600);
        response.addCookie(cookie);

        return Login.Response.of(user);
    }

    @Transactional
    protected User saveOrUpdate(UserRequest userRequest) {
        User user = userRepository.findByEmail(userRequest.getEmail())
                .map(entity -> entity.update(userRequest.getNickname(), userRequest.getProfileImage()))
                .orElse(userRequest.toEntity());
        return userRepository.save(user);
    }

    // 로그인시
    @PostMapping("/loginUser")
    public UserInfoDto loginUser(HttpServletRequest request) {
        String token = jwtTokenProvider.resolveToken(request);
        String email = jwtTokenProvider.getUid(token);
        return userService.userInfo(email);
    }

    // 로그아웃
    @PostMapping("/logoutUser")
    public Boolean logoutUser(HttpServletRequest request, HttpServletResponse response) {
        cookieReset(request, response);
        return true;
    }

    // 회원 탈퇴
    @DeleteMapping("/resign/{userId}")
    public Boolean resignUser(@PathVariable Long userId, HttpServletRequest request, HttpServletResponse response) {
        userService.resign(userId);
        cookieReset(request, response);
        return true;
    }

    // 쿠키 삭제
    private Cookie cookieReset(HttpServletRequest request, HttpServletResponse response) {
        String token = jwtTokenProvider.resolveToken(request);
        Cookie cookie = new Cookie("Auth", token);
        cookie.setMaxAge(0);
        cookie.setPath("/"); //모든 경로에서 지워짐
        response.addCookie(cookie);
        return cookie;
    }
}
