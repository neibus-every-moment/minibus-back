package com.minibus.moment.dto;

import com.minibus.moment.domain.reportReason.ReportReason;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportReasonDto {

    private String reportReason;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        private Integer id;
        private String reportReason;
        private Long reportId;
    }

    public static ReportReasonDto from(ReportReason reportReason) {
        return ReportReasonDto.builder()
                .reportReason(reportReason.getContent())
                .build();
    }
}
