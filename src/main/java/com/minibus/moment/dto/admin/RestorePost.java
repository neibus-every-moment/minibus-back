package com.minibus.moment.dto.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class RestorePost {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        private Long id;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Long date;
    }
}
