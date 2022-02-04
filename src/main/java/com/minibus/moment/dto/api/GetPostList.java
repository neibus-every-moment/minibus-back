package com.minibus.moment.dto.api;

import com.minibus.moment.dto.PostDto;
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
        private List<String> transportationName;
        private List<String> regionName;
        private String sorting;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private List<PostDto> data;
    }
}
