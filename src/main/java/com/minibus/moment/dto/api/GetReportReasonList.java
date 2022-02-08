package com.minibus.moment.dto.api;

import com.minibus.moment.dto.ReportReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

public class GetReportReasonList {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private List<String> data;

        public static Response toResponse(List<ReportReasonDto> reportReasonDtoList){
            return new Response(reportReasonDtoList.stream().map(ReportReasonDto::getReportReason).collect(Collectors.toList()));
            }
    }
}
