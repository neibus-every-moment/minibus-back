package com.minibus.moment.dto.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateComment {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request{
        @Size(min = 0)
        @NotNull(message = "포스트 ID를 입력해주세요.")
        private Long postId;
        @NotNull(message = "유저 ID를 입력해주세요.")
        private Long userId;
        @NotNull(message = "댓글 내용을 입력해주세요.")
        private String content;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Long data;
    }
}
