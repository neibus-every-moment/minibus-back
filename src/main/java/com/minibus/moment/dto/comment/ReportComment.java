package com.minibus.moment.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReportComment {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        private Long commentId; // 포스트 id
        private String reportReason; // 신고 사유 id
        private String detail; // Optional 신고 사유가 기타일 때 세부사항
    }
}
