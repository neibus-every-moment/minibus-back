package com.minibus.moment.dto.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;

public class LikePost {


    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private boolean result;
    }
}
