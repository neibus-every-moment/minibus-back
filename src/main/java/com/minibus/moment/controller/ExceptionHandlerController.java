package com.minibus.moment.controller;

import com.minibus.moment.dto.api.*;
import com.minibus.moment.exception.*;
import com.minibus.moment.service.EmoticonService;
import com.minibus.moment.service.PostService;
import com.minibus.moment.service.RegionService;
import com.minibus.moment.service.TransportationService;
import lombok.RequiredArgsConstructor;
import org.hibernate.TransientPropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @ExceptionHandler(EmoticonNotFoundException.class)
    public ResponseEntity<?> EmoticonNotFoundExceptionHandler(EmoticonNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ReportReasonId.class)
    public ResponseEntity<?> ReportReasonIdExceptionHandler(ReportReasonId exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
