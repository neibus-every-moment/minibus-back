package com.minibus.moment.dto;

import com.minibus.moment.domain.reportCategory.ReportCategory;
import com.minibus.moment.domain.reportEtcDetail.ReportEtcDetail;
import com.minibus.moment.type.PostStatus;
import com.minibus.moment.type.ReportStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportDto {
    private int reportCategoryId;
    private Long id;
    private String content;
    private PostStatus reportStatus;
    private ReportEtcDetail reportEtcDetail;

}
