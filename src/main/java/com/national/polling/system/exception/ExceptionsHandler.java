package com.national.polling.system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> resourceNotFoundExceptionHandler(Exception exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConflictWithExistingRecordException.class)
    public ResponseEntity<Object> conflictWithExistingRecordExceptionHandler(Exception exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }
}
