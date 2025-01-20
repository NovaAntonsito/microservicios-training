package com.tutorial.msdockerpersonas.controllers.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@Slf4j
@ControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundHandling(WebRequest request,ResourceNotFoundException e){
        log.error("Error in resourceNotFoundHandling: " + request.getDescription(false));
        ErrorDetails errorDetails =
                new ErrorDetails(
                        new Date(),
                        e.getMessage(),
                        request.getDescription(false)
                );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DatabaseEmptyException.class)
    public ResponseEntity<ErrorDetails> databaseEmptyHandling(DatabaseEmptyException e, WebRequest request) {
        log.error("Error in databaseEmptyHandling: " + request.getDescription(false));
        ErrorDetails errorDetails = new ErrorDetails(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NO_CONTENT);
    }

}
