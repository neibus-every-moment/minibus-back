package com.minibus.moment.dto.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CreateComment {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request{
        private Long postId;
        private String content;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Long data;
    }
}
