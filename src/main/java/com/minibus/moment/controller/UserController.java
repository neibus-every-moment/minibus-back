package com.minibus.moment.controller;

import com.minibus.moment.domain.user.User;
import com.minibus.moment.domain.user.UserRepository;
import com.minibus.moment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @DeleteMapping("/my-page/user/resign/{email}")
    public String resign(@PathVariable String email) {
        userService.resign(email);
        return "forward:/logout";
    }
}
