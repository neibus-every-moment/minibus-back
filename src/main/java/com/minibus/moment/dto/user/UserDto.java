package com.minibus.moment.dto.user;

import com.minibus.moment.domain.user.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private String email;
    private String avatar;
    private String nickname;

    public static UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .avatar(user.getProfileImage())
                .nickname(user.getNickname())
                .build();
    }
}
