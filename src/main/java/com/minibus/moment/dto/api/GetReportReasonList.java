package com.minibus.moment.dto.api;

import com.minibus.moment.dto.ReportReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class GetReportReasonList {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private List<ReportReasonDto> data;
    }
}
