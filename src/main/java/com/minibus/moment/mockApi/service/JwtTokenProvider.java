package com.minibus.moment.mockApi.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;

@Service
@Slf4j
public class JwtTokenProvider {
    private static String secretKey = Base64.getEncoder().encodeToString("fastcampusfinalprojectminibusandneibus".getBytes());

    // JWT 토큰 생성
    public Token generateToken(String uid, String role) {
        //토큰 유효시간 지정
        long tokenPeriod = 1000L * 60L * 60L; // 1시간

        Claims claims = Jwts.claims().setSubject(uid);
        claims.put("role", role);

        Date now = new Date();
        return new Token(
                Jwts.builder()
                        .setClaims(claims)
                        .setIssuedAt(now)
                        .setExpiration(new Date(now.getTime() + tokenPeriod))
                        .signWith(SignatureAlgorithm.HS256, secretKey)
                        .compact()
        );
    }

    // 토큰의 유효성 + 만료일자 확인
    public boolean verifyToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token);
            return claims.getBody()
                    .getExpiration()
                    .after(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    //토큰 회원 정보 추출
    public static String getUid(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public String resolveToken(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                String name = c.getName();
                String value = c.getValue();
                if (name.equals("Auth")) {
                    System.out.println("value = " + value);
                    return value;
                }
            }
        }
        return null;
    }

}