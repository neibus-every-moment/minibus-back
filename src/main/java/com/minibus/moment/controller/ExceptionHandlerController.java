package com.minibus.moment.controller;

import com.minibus.moment.exception.PostNotFoundException;
import com.minibus.moment.exception.RegionNotFoundException;
import com.minibus.moment.exception.ReportReasonNotFoundException;
import com.minibus.moment.exception.TransportationNotFoundException;
import org.hibernate.TransientPropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<?> PostNotFoundExceptionHandler(PostNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RegionNotFoundException.class)
    public ResponseEntity<?> RegionNotFoundExceptionHandler(RegionNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TransientPropertyValueException.class)
    public ResponseEntity<?> TransportationNotFoundExceptionHandler(TransportationNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ReportReasonNotFoundException.class)
    public ResponseEntity<?> ReportReasonIdExceptionHandler(ReportReasonNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
