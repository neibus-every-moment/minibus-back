package com.minibus.moment.dto.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReportRequest {

    private String reportReason; // 신고 사유 id
    private String detail; // Optional 신고 사유가 기타일 때 세부사항
}
