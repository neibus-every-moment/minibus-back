//package com.minibus.moment.auth.controller;
//
//import com.minibus.moment.auth.dto.ApiResponse;
//import com.minibus.moment.auth.dto.AuthResponse;
//import com.minibus.moment.auth.dto.LoginRequest;
//import com.minibus.moment.auth.dto.SignUpRequest;
//import com.minibus.moment.auth.exception.BadRequestException;
//import com.minibus.moment.auth.security.TokenProvider;
//import com.minibus.moment.domain.user.AuthProvider;
//import com.minibus.moment.domain.user.User;
//import com.minibus.moment.domain.user.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import java.net.URI;
//
//@RequiredArgsConstructor
//@RequestMapping("/auth")
//@RestController
//public class AuthController {
//
//    private final AuthenticationManager authenticationManager;
//
//    private final UserRepository userRepository;
//
//    private final PasswordEncoder passwordEncoder;
//
//    private final TokenProvider tokenProvider;
//
//    @PostMapping("/login")
//    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
//
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        loginRequest.getEmail(),
//                        loginRequest.getPassword()
//                )
//        );
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        String token = tokenProvider.createToken(authentication);
//        System.out.println("token = " + token);
//        return ResponseEntity.ok(new AuthResponse(token));
//    }
//
//    @PostMapping("/signup")
//    public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest) {
//        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
//            throw new BadRequestException("이미 사용중인 이메일입니다.");
//        }
//
//        // 계정 생성
//        User result = userRepository.save(User.builder()
//                .nickname(signUpRequest.getName())
//                .email(signUpRequest.getEmail())
////                .password(passwordEncoder.encode(signUpRequest.getPassword()))
////                        .profileImage()
//                .provider(AuthProvider.kakao)
//                .build()
//        );
//
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentContextPath().path("/user/me")
//                .buildAndExpand(result.getId()).toUri();
//
//        return ResponseEntity.created(location)
//                .body(new ApiResponse(true, "성공적으로 계정 생성이 되었습니다."));
//    }
//}