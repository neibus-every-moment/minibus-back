package com.minibus.moment.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UpdateProfile {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        private String nickname;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Long data;
    }
}
