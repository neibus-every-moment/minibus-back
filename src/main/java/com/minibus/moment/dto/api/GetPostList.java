package com.minibus.moment.dto.api;

import com.minibus.moment.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class GetPostList {

    @Getter
    @Setter 
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        @Size(min = 0)
        @NotNull(message = "시작페이지 숫자를 입력해주세요.")
        private Integer start;
        @Size(min = 0)
        @NotNull(message = "페이지 사이즈를 입력해주세요")
        private Integer size;
        private List<String> transportations;
        private List<String> regions;
        @NotNull(message = "createdAt, likeCount 중 하나를 입력해주세요.")
        private String sorting;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyRequest {
        private Long userId;
    }


    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private List<PostDto> data;
    }
}
