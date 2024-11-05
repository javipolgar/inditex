package com.javi.inditex.controller;

import com.javi.inditex.model.dto.PriceResponse;
import com.javi.inditex.service.PriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class PriceControllerTest {

    @Mock
    private PriceService priceService;

    @InjectMocks
    private PriceController priceController;

    private PriceResponse priceEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        priceEntity = new PriceResponse();
        priceEntity.setBrandId(1);
        priceEntity.setProductId(35455);
        priceEntity.setPrice(BigDecimal.valueOf(35.50));
        priceEntity.setStartDate(LocalDateTime.of(2020, 6, 14, 0, 0));
        priceEntity.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59));
    }

    @Test
    void shouldFoundPrice() {
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);

        when(priceService.getPrice(35455, 1, applicationDate)).thenReturn(priceEntity);

        ResponseEntity<PriceResponse> response = priceController.getPrice(1 , 35455, applicationDate);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(priceEntity, response.getBody());
    }
}