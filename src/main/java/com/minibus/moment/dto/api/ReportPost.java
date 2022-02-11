package com.minibus.moment.dto.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ReportPost {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        @Size(min = 0)
        @NotNull(message = "글 ID를 입력해주세요.")
        private Long postId; // 포스트 id
        @NotNull(message = "신고 사유를 입력해주세요.")
        private String reportReason; // 신고 사유 String
        private String detail; // Optional 신고 사유가 기타일 때 세부사항
    }
}
