package com.minibus.moment.auth.dto;

import com.minibus.moment.auth.dto.UserDto;
import com.minibus.moment.domain.user.User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserRequestMapper {

    public UserDto toDto(OAuth2User oAuth2User) {
        Map<String, Object> attributes = oAuth2User.getAttributes();
        Map<String, Object> account = (Map<String, Object>) attributes.get("kakao_account");
        Map<String, Object> profile = (Map<String, Object>) account.get("profile");
        return UserDto.builder()
                .name((String) profile.get("nickname"))
                .email((String) account.get("email"))
                .build();
    }
}
