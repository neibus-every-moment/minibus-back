package com.minibus.moment.dto;

import com.minibus.moment.domain.reportReason.ReportReason;
import lombok.*;

import javax.validation.constraints.NotNull;

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
        @NotNull(message = "신고사유를 입력해주세요.")
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
