package com.minibus.moment.exception;

import lombok.Getter;

@Getter
public class OauthException extends RuntimeException {

    private OauthErrorCode errorCode;
    private String message;

    public OauthException(OauthErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
    }

}
