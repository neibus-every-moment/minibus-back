package com.minibus.moment.dto.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class BlindPost {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        private Long id;
        private String content;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Long data;
    }

}
