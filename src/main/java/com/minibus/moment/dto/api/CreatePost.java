package com.minibus.moment.dto.api;

import com.minibus.moment.dto.PostDto;
import lombok.*;

public class CreatePost {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        private String content;
        private String regionName;
        private String transportationName;
        private String emoticonName;
        private String base64Image;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private PostDto data;
    }
}
