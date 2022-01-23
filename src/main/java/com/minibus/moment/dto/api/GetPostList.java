package com.minibus.moment.dto.api;

import com.minibus.moment.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class GetPostList {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request{
        private Integer start;
        private Integer size;
        private String transportationName;
        private String regionName;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response{
        private List<PostDto> data;
    }
}
