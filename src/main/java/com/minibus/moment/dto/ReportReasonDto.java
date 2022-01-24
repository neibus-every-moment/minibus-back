package com.minibus.moment.dto;

import com.minibus.moment.domain.reportReason.ReportReason;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportReasonDto {

    private Integer id;
    private String reportReason;

    public static ReportReasonDto from(ReportReason reportReason) {
        return ReportReasonDto.builder()
                .id(reportReason.getId())
                .reportReason(reportReason.getContent())
                .build();
    }

}
