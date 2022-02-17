package com.minibus.moment.dto.report;

import com.minibus.moment.domain.report.ReportReason;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportReasonDto {

    private String reportReason;

    public static ReportReasonDto from(ReportReason reportReason) {
        return ReportReasonDto.builder()
                .reportReason(reportReason.getContent())
                .build();
    }

}
