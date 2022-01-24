package com.minibus.moment.dto.api;

import com.minibus.moment.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class GetPost {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response{
        private PostDto data;
    }
}
