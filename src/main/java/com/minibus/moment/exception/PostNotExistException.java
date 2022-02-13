package com.minibus.moment.exception;

public class PostNotExistException extends RuntimeException{
    public PostNotExistException(String message) {
        super(message);
    }
}
