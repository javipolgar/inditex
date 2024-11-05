package com.javi.inditex.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


/**
 * Test class for GlobalExceptionHandler.
 * This class verifies the behavior of the exception handler
 * when a NotFoundException is thrown.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Test for the handlePriceNotFoundException method.
     * Verifies that the NotFoundException is handled correctly.
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}