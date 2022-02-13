package com.minibus.moment.dto.transportation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CreateTransportation {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        private String transportationName;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response{
        private Integer data;
    }
}
