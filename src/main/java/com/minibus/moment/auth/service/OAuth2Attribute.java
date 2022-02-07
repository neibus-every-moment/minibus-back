package com.minibus.moment.auth.service;

import com.minibus.moment.domain.user.Role;
import com.minibus.moment.domain.user.User;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Slf4j
public class OAuth2Attribute {
    private Map<String, Object> attributes;
    private String attributeKey;
    private String email;
    private String name;

    //플랫폼 확인
    static OAuth2Attribute of(String provider, String attributeKey, Map<String, Object> attributes) {
        if (provider.equals("kakao")) {
            return ofKakao(attributeKey, attributes);
        } else {
            throw new RuntimeException(); //Todo: 예외처리
        }
    }

    //카카오 유저일 경우
    private static OAuth2Attribute ofKakao(String attributeKey, Map<String, Object> attributes) {
        Map<String, Object> kakao_account = (Map<String, Object>) attributes.get("kakao_account");
        Map<String, Object> profile = (Map<String, Object>) kakao_account.get("profile");

        return OAuth2Attribute.builder()
                .name((String) profile.get("nickname"))
                .email((String) kakao_account.get("email"))
                .attributeKey(attributeKey)
                .attributes(attributes)
                .build();
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .role(Role.USER)
                .build();
    }

}
