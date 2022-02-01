package com.minibus.moment.config.auth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {

    //index.html
    @GetMapping("/oauth-login")
    public String login() {
        return "forward:oauth-login.html";
    }

    //로그인 성공 url
    @GetMapping("/login-success")
    public String success() {
        return "forward:login-success.html";
    }

    @GetMapping("/my-page")
    public String myPage() {
        return "forward:mypage.html";
    }
}
