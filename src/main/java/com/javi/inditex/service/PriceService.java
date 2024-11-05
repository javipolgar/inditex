package com.javi.inditex.service;

import com.javi.inditex.model.dto.PriceResponse;

import java.time.LocalDateTime;

public interface PriceService {

    PriceResponse getPrice(int brandId, int productId, LocalDateTime applicationDate);
}
