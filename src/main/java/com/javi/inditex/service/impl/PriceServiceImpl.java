package com.javi.inditex.service.impl;

import com.javi.inditex.mapper.PriceMapper;
import com.javi.inditex.model.dto.PriceResponse;
import com.javi.inditex.model.entity.PriceEntity;
import com.javi.inditex.repository.PriceRepository;
import com.javi.inditex.service.PriceService;
import com.javi.inditex.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


/**
 * Implementation of the price service.
 * This class handles the logic for retrieving product prices.
 */

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

    private final PriceRepository repository;


    /**
     * Method to retrieve the price of a specific product on a given date.
     */
    @Override
    public PriceResponse getPrice(int productId, int brandId, LocalDateTime applicationDate) {
        List<PriceEntity> prices = repository.findPrices(productId, brandId, applicationDate);

        if (prices == null || prices.isEmpty()){
            throw new NotFoundException("Price not found for productId: " + productId
                    + ", brandId: " + brandId + ", applicationDate: " + applicationDate);        }



        return PriceMapper.toDto(prices.get(0));
    }
}
