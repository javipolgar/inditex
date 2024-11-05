package com.javi.inditex.exception;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GlobalExceptionHandlerTest {
    private final GlobalExceptionHandler exceptionHandler = new GlobalExceptionHandler();

    @Test
    void testHandlePriceNotFoundException() {
        NotFoundException exception = new NotFoundException("Price not found for productId: 35455, brandId: 1, applicationDate: 2020-06-14T10:00");

        WebRequest request = Mockito.mock(WebRequest.class);

        ResponseEntity<?> response = exceptionHandler.handleNotFoundException(exception, request);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        assertEquals("Price not found for productId: 35455, brandId: 1, applicationDate: 2020-06-14T10:00", response.getBody());
    }

}