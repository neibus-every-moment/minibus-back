package com.minibus.moment.dto;

import com.minibus.moment.domain.reportCategory.ReportCategory;
import com.minibus.moment.domain.reportEtcDetail.ReportEtcDetail;
import com.minibus.moment.type.ReportStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportDto {

    private ReportCategory reportCategory;
    private ReportEtcDetail reportEtcDetail;
    private ReportStatus reportStatus;
    private LocalDateTime createdAt;
}
