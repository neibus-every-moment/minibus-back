package com.minibus.moment.controller;


import com.minibus.moment.auth.config.Token;
import com.minibus.moment.auth.service.JwtTokenProvider;
import com.minibus.moment.dto.UserDto;
import com.minibus.moment.dto.api.Login;
import com.minibus.moment.dto.api.MyPage;
import com.minibus.moment.service.CommentService;
import com.minibus.moment.service.PostService;
import com.minibus.moment.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {

    private final UserService userService;
    private final PostService postService;
    private final CommentService commentService;
    private final JwtTokenProvider jwtTokenProvider;

    @GetMapping("/login/{userId}")
    public Login.Response login(@PathVariable Long userId, HttpServletResponse response){
        UserDto user = userService.login(userId);

        Token token = jwtTokenProvider.generateToken(user.getEmail(), "USER");
        Cookie cookie = new Cookie("Auth", token.getToken());
        cookie.setMaxAge(3600);
        response.addCookie(cookie);

        return new Login.Response(user);
    }

    @GetMapping("/my-page")
    public MyPage getMyPage(){
        String email = jwtTokenProvider.getUid(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());

        UserDto user = userService.getUser(email);
        Integer postCount = postService.getPostListByUser(user.getId()).size();
        Integer commentCount = commentService.getCommentListByUser(user.getId()).size();
        return new MyPage(user,postCount,commentCount);
    }
}
