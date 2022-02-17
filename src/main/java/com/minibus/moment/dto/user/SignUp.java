package com.minibus.moment.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class SignUp {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {

        private String email;
        private String password;
        private String nickname;
    }
}
