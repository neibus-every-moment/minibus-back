package com.minibus.moment.dto.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class GetPost {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response{
        private PostDto data;
    }
}
