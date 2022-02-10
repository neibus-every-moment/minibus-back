//package com.minibus.moment.auth.controller;
//
//import com.minibus.moment.auth.exception.ResourceNotFoundException;
//import com.minibus.moment.auth.security.CurrentUser;
//import com.minibus.moment.auth.security.UserPrincipal;
//import com.minibus.moment.domain.user.User;
//import com.minibus.moment.domain.user.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RequiredArgsConstructor
//@RestController
//public class UserController {
//
//    private final UserRepository userRepository;
//
//    @GetMapping("/user/me")
//    @PreAuthorize("hasRole('USER')")
//    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
//        return userRepository.findById(userPrincipal.getId())
//                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
//    }
//}
