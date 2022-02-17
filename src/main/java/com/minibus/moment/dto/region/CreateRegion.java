package com.minibus.moment.dto.region;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CreateRegion {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        private String regionName;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Integer data;
    }
}
