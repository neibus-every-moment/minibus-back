package com.minibus.moment.dto.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReportPost {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        private Long postId; // 포스트 id
        private Integer reportReasonId; // 신고 사유 id
        private String detail; // Optional 신고 사유가 기타일 때 세부사항
    }
}
