package com.tutorial.msdockerpersonas.controllers.exceptions.classes;

import com.tutorial.msdockerpersonas.controllers.exceptions.DatabaseEmptyException;
import com.tutorial.msdockerpersonas.controllers.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
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
    public ResponseEntity<?> resourceNotFoundHandling(@NotNull WebRequest request,@NotNull ResourceNotFoundException e){
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
    public ResponseEntity<ErrorDetails> databaseEmptyHandling(@NotNull DatabaseEmptyException e, @NotNull WebRequest request) {
        log.error("Error in databaseEmptyHandling: " + request.getDescription(false));
        ErrorDetails errorDetails = new ErrorDetails(
                new Date(),
                e.getMessage(),
                request.getDescription(false)
        );
        log.error(errorDetails.toString());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

}
