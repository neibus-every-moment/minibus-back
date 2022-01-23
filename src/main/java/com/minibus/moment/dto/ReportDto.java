package com.minibus.moment.dto;

import com.minibus.moment.domain.report.Report;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportDto {

    private Long id;
    private Long postId;
    private String reportReason;
    private String reportStatus;

    public static ReportDto from(Report report){
        return ReportDto.builder()
                .id(report.getId())
                .postId(report.getPost().getId())
                .reportReason(report.getReportReason().getContent())
                .reportStatus(report.getReportStatus().toString()) //check
                .build();
    }
}
