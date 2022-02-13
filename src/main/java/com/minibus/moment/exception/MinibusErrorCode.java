package com.minibus.moment.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MinibusErrorCode {


    POST_NOT_FOUND("해당 포스트가 존재하지 않습니다."),
    COMMENT_NOT_FOUND("해당 댓글이 존재하지 않습니다"),
    REGION_NOT_FOUND("해당 지역이 존재하지 않습니다."),
    TRANSPORTATION_NOT_FOUND("해당 교통수단이 존재하지 않습니다."),
    REPORT_REASON_NOT_FOUND("해당 신고사유가 존재하지 않습니다."),
    BLIND_NOT_FOUND("해당 블라인드 내역이 존재하지 않습니다."),
    USER_NOT_FOUND("해당 유저가 존재하지 않습니다."),

    DUPLICATED_REGION("이미 존재하는 지역 입니다."),
    DUPLICATED_TRANSPORTATION("이미 존재하는 교통수단 입니다."),
    DUPLICATED_REPORT_REASON("이미 존재하는 신고사유 입니다."),

    INVALID_TOKEN("유효하지 않은 토큰입니다.");

    private final String message;
}
