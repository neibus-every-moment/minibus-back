package com.minibus.moment.dto.report;

import com.minibus.moment.domain.reportReason.ReportReason;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportReasonDto {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        private Integer id;
        private String reportReason;
        private Long reportId;
    }

    private String reportReason;

    public static ReportReasonDto from(ReportReason reportReason) {
        return ReportReasonDto.builder()
                .reportReason(reportReason.getContent())
                .build();
    }

}
