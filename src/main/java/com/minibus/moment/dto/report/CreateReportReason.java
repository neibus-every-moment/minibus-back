package com.minibus.moment.dto.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CreateReportReason {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request{
        private String content;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response{
        private Integer data;
    }
}
