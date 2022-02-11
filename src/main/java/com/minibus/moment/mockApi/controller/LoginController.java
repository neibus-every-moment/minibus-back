package com.minibus.moment.mockApi.controller;

import com.minibus.moment.domain.user.User;
import com.minibus.moment.domain.user.UserRepository;
import com.minibus.moment.dto.UserInfoDto;
import com.minibus.moment.mockApi.dto.UserRequest;
import com.minibus.moment.mockApi.service.JwtTokenProvider;
import com.minibus.moment.mockApi.service.Token;
import com.minibus.moment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class LoginController {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final UserService userService;

    //email로 요청 받으면 토큰을 발급
    @PostMapping("/login")
    public Token login(@RequestBody UserRequest userRequest) {
        Token token = jwtTokenProvider.generateToken(userRequest.getEmail(), "USER");
        saveOrUpdate(userRequest);
        Cookie cookie = new Cookie("Auth", token.getToken());
        cookie.setHttpOnly(true);
        System.out.println("cookie = " + cookie.getValue());
        return token;
    }

    private User saveOrUpdate(UserRequest userRequest) {
        User user = userRepository.findByEmail(userRequest.getEmail())
                .map(entity -> entity.update(userRequest.getNickname(), userRequest.getProfileImage()))
                .orElse(userRequest.toEntity());
        return userRepository.save(user);
    }


    //로그인시
    @PostMapping("/loginUser")
    public UserInfoDto loginUser(HttpServletRequest request) {
        String token = jwtTokenProvider.resolveToken(request);
        if (token != null && jwtTokenProvider.verifyToken(token)) { //유효 토큰인지 확인
            String email = jwtTokenProvider.getUid(token);
            return userService.userInfo(email);
        }
        else {
            throw new RuntimeException(); //Todo: 예외처리(해당 토큰은 유효하지 않습니다.)
        }
    }

    //로그아웃
    @PostMapping("/logoutUser")
    public Boolean logoutUser(HttpServletRequest request, HttpServletResponse response) {
        CookieReset(request, response);
        return true;
    }

    //회원 탈퇴
    @DeleteMapping("/resign/{userId}")
    public Boolean resignUser(@PathVariable Long userId, HttpServletRequest request, HttpServletResponse response) {
        userService.resign(userId);
        CookieReset(request, response);
        return true;
    }

    // 쿠키 삭제
    private Cookie CookieReset(HttpServletRequest request, HttpServletResponse response) {
        String token = jwtTokenProvider.resolveToken(request);
        Cookie cookie = new Cookie("Auth", token);
        cookie.setMaxAge(0);
        cookie.setPath("/"); //모든 경로에서 지워짐
        response.addCookie(cookie);
        return cookie;
    }
}
