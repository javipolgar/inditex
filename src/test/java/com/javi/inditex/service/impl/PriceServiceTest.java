package com.javi.inditex.service.impl;

import com.javi.inditex.exception.NotFoundException;
import com.javi.inditex.model.dto.PriceResponse;
import com.javi.inditex.model.entity.PriceEntity;
import com.javi.inditex.repository.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
class PriceServiceTest {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PriceServiceImpl priceService;

    private PriceEntity priceEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        priceEntity = new PriceEntity();
        priceEntity.setBrandId(1);
        priceEntity.setProductId(35455);
        priceEntity.setPrice(BigDecimal.valueOf(35.50));
        priceEntity.setStartDate(LocalDateTime.of(2020, 6, 14, 0, 0));
        priceEntity.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59));
    }

    @Test
    void shouldFoundPrice() {
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);

        when(priceRepository.findPrices(35455, 1, applicationDate)).thenReturn(List.of(priceEntity));

        PriceResponse result = priceService.getPrice(35455, 1, applicationDate);

        assertEquals(priceEntity.getPrice(), result.getPrice());
    }

    @Test
    void shouldNotFoundPrice() {
        int productId = 35455;
        int brandId = 1;
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);

        when(priceRepository.findPrices(productId, brandId, applicationDate))
                .thenReturn(Collections.emptyList());

        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            priceService.getPrice(productId, brandId, applicationDate);
        });

        assertEquals("Price not found for productId: 35455, brandId: 1, applicationDate: 2020-06-14T10:00", exception.getMessage());
    }

}