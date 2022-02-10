package com.minibus.moment.dto.api;

import com.minibus.moment.dto.UserDto;
import lombok.*;

public class Login {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {

        private UserDto user;
    }
}