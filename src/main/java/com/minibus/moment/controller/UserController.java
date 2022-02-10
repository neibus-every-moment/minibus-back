//package com.minibus.moment.controller;
//
//import com.minibus.moment.auth.security.TokenProvider;
//import com.minibus.moment.dto.UserInfoDto;
//import com.minibus.moment.service.UserService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletResponse;
//
//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/api")
//@Slf4j
//public class UserController {
//
//    private final UserService userService;
//    TokenProvider tokenProvider = new TokenProvider();
//
//    //최초 로그인시
//    @PostMapping("/loginUser")
//    public UserInfoDto loginUser() {
//        String token = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String email = tokenProvider.getUserIdFromToken(token);
//        log.info("email = {}", email);
//
//        return userService.userInfo(email);
//    }
//
//    //로그아웃
//    @PostMapping("/logoutUser")
//    public Boolean logoutUser(HttpServletResponse response) {
//        CookieReset(response);
//        return true;
//    }
//
//    //회원탈퇴
//    @DeleteMapping("/resign/{userId}") //Todo: 테스트
//    public Boolean resignUser(@PathVariable Long userId, HttpServletResponse response) {
//        userService.resign(userId);
//        CookieReset(response);
//        return true;
//    }
//
//    //닉네임 변경
////    @PostMapping("/username/")
//
//    // 쿠키 삭제
//    private Cookie CookieReset(HttpServletResponse response) {
//        String token = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        log.info("token = {}", token);
//        Cookie cookie = new Cookie("Auth", token);
//        cookie.setMaxAge(0);
//        cookie.setPath("/"); //모든 경로에서 지워짐
//        response.addCookie(cookie);
//        return cookie;
//    }
//}
