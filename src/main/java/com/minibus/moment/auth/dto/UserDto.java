package com.minibus.moment.auth.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Getter
public class UserDto implements Serializable {
    private String email;
    private String name;

    @Builder
    public UserDto(String email, String name) {
        this.email = email;
        this.name = name;
    }
}
