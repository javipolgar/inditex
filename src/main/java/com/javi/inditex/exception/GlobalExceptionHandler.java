package com.javi.inditex.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


/**
 * Clase de prueba para GlobalExceptionHandler.
 * Esta clase verifica el comportamiento del manejador de excepciones
 * al lanzar NotFoundException.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Prueba para el método handlePriceNotFoundException.
     * Verifica que se maneje correctamente la excepción NotFoundException.
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}