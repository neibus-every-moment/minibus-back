package com.minibus.moment.dto.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreatePost {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        @Size(min = 0)
        @NotNull(message = "유저 ID값을 입력해주세요.")
        private Long userId;
        @NotNull(message = "본문을 입력해주세요.")
        private String content;
        @NotNull(message = "지역을 입력해주세요.")
        private String region;
        @NotNull(message = "교통수단을 입력해주세요.")
        private String transportation;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Long data;
    }
}
