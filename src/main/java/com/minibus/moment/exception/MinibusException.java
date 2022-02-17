package com.minibus.moment.exception;

import lombok.Getter;

@Getter
public class MinibusException extends RuntimeException {

    private MinibusErrorCode errorCode;
    private String message;

    public MinibusException(MinibusErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
    }
}
