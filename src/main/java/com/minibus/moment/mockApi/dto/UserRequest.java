package com.minibus.moment.mockApi.dto;

import com.minibus.moment.domain.user.Role;
import com.minibus.moment.domain.user.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {
    private String email;
    private String nickname;
    private String role;
    private String profileImage;

    public User toEntity() {
        return User.builder()
                .nickname(nickname)
                .email(email)
                .role(Role.USER)
                .profileImage(profileImage)
                .build();
    }
}

