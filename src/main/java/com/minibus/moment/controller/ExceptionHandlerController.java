package com.minibus.moment.controller;

import com.minibus.moment.exception.*;
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

    @ExceptionHandler(TokenIsNotValidException.class)
    public ResponseEntity<?> TokenIsNotValidExceptionHandler(TokenIsNotValidException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> UserNotFoundExceptionHandler(UserNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BlindNotFoundException.class)
    public ResponseEntity<?> BlindNotFoundExceptionHandler(BlindNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FindNotPlatformException.class)
    public ResponseEntity<?> FindNotPlatformExceptionHandler(FindNotPlatformException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TransportationAlreadyExistException.class)
    public ResponseEntity<?> TransportationAlreadyExistExceptionHandler(TransportationAlreadyExistException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ReportReasonAlreadyExistException.class)
    public ResponseEntity<?> ReportReasonAlreadyExistExceptionHandler(ReportReasonAlreadyExistException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RegionAlreadyExistException.class)
    public ResponseEntity<?> RegionAlreadyExistExceptionHandler(RegionAlreadyExistException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
