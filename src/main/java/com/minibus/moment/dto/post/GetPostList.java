package com.minibus.moment.dto.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

public class GetPostList {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        private Integer start;
        private Integer size;
        private List<String> transportations;
        private List<String> regions;
        private String sorting;
    }


    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private List<PostDto> data;
    }
}
