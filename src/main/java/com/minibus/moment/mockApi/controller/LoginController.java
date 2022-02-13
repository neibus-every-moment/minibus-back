package com.minibus.moment.mockApi.controller;

import com.minibus.moment.auth.config.Token;
import com.minibus.moment.auth.service.JwtTokenProvider;
import com.minibus.moment.domain.user.User;
import com.minibus.moment.domain.user.UserRepository;
import com.minibus.moment.dto.UserDto;
import com.minibus.moment.dto.UserInfoDto;

import com.minibus.moment.exception.TokenIsNotValidException;
import com.minibus.moment.dto.api.Login;
import com.minibus.moment.mockApi.dto.UserRequest;
//import com.minibus.moment.mockApi.service.Token;
import com.minibus.moment.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final UserService userService;

    //조회와 동시에 jwt 토큰 발급
    @GetMapping("/login/{userId}")
    public Login.Response login(@PathVariable Long userId, HttpServletResponse response){
        User user = userService.login(userId);
        Token token = jwtTokenProvider.generateToken(user.getEmail(), "USER");
        Cookie cookie = new Cookie("Auth", token.getToken());
        cookie.setMaxAge(3600);
        response.addCookie(cookie);

        return Login.Response.of(user);
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

    /**
     * 추후에 oauth2를 이용해 로그인 성공시 사용(login(), loginUser())
     */
    // email로 요청 받으면 jwt 토큰을 발급
    @PostMapping("/login")
    public Token login(@RequestBody UserRequest userRequest, HttpServletResponse response) {
        Token token = jwtTokenProvider.generateToken(userRequest.getEmail(), "USER");
        userService.saveOrUpdate(userRequest);
        Cookie cookie = new Cookie("Auth", token.getToken());
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return token;
    }

    // 로그인시
    @PostMapping("/loginUser")
    public UserInfoDto loginUser(HttpServletRequest request) {
        String token = jwtTokenProvider.resolveToken(request);
        String email = jwtTokenProvider.getUid(token);
        return userService.userInfo(email);
    }

}
