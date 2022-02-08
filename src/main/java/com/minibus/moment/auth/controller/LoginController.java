package com.minibus.moment.auth.controller;

import com.minibus.moment.auth.service.JwtTokenProvider;
import com.minibus.moment.domain.user.User;
import com.minibus.moment.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class LoginController {

    private final UserRepository userRepository;

    @GetMapping("/")
    public String index() {
        return "hello";
    }

//    @GetMapping("/login/user")
//    public void login() {
//        userRepository.findByEmail()
//    }
}
