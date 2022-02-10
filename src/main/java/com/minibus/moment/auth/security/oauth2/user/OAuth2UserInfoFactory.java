package com.minibus.moment.auth.security.oauth2.user;

import com.minibus.moment.auth.exception.OAuth2AuthenticationProcessingException;
import com.minibus.moment.domain.user.AuthProvider;

import java.util.Map;

public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if (registrationId.equalsIgnoreCase(AuthProvider.kakao.toString())) {
            return new KakaoOAuth2UserInfo(attributes);
        } else {
            throw new OAuth2AuthenticationProcessingException("해당 플랫폼이 존재하지 않습니다.");
        }
    }
}
