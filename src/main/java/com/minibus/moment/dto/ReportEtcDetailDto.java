package com.minibus.moment.dto;

import com.minibus.moment.domain.post.Post;
import com.minibus.moment.domain.reportCategory.ReportCategory;
import com.minibus.moment.domain.reportEtcDetail.ReportEtcDetail;
import com.minibus.moment.type.ReportStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportEtcDetailDto {

    private ReportEtcDetail content;
}
