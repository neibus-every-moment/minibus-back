package com.minibus.moment.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OauthErrorCode {

    INVALID_PLATFORM("해당 플랫폼은 지원하지 않습니다");

    private final String message;
}
