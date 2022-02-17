package com.minibus.moment.controller;

import com.minibus.moment.dto.exception.ErrorResponse;
import com.minibus.moment.exception.MinibusException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(MinibusException.class)
    public ErrorResponse MinibusExceptionHandler(MinibusException e, HttpServletRequest request) {
        log.error("errorCode : {} , message : {}, requestURL : {}", e.getErrorCode(), e.getMessage(), request.getRequestURL());
        return ErrorResponse.builder()
                .errorCode(e.getErrorCode())
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> RegionNotFoundExceptionHandler(IllegalArgumentException e, HttpServletRequest request) {
        log.error("message : {}, requestURL : {}", e.getMessage(), request.getRequestURL());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> RegionNotFoundExceptionHandler(Exception e, HttpServletRequest request) {
        log.error("message : {}, requestURL : {}", e.getMessage(), request.getRequestURL());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
