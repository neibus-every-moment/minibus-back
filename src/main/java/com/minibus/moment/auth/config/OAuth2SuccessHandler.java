package com.minibus.moment.auth.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.minibus.moment.auth.dto.UserDto;
import com.minibus.moment.auth.dto.UserRequestMapper;
import com.minibus.moment.auth.service.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@Component
@Slf4j
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {

    private final UserRequestMapper userRequestMapper;
    private final JwtTokenProvider jwtTokenProvider;
    private final ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        UserDto userDto = userRequestMapper.toDto(oAuth2User);
        log.info("userDto.getEmail() = " + userDto.getEmail());

        Token token = jwtTokenProvider.generateToken(userDto.getEmail(), "USER");
        writeTokenResponse(response, token);
    }

    //Cookie에 생성된 토큰 값을 저장하며 Cookie 시간 등록
    private void writeTokenResponse(HttpServletResponse response, Token token) throws IOException {
        Cookie cookie = new Cookie("Auth", token.getToken());
        cookie.setMaxAge(3600);
        response.addCookie(cookie);

        var writer = response.getWriter();
        writer.println(objectMapper.writeValueAsString(token));
        writer.flush();
    }
}
