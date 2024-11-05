package com.javi.inditex.controller;


import com.javi.inditex.model.dto.PriceResponse;
import com.javi.inditex.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


/**
 * Controller to handle requests related to prices.
 * This controller provides a REST endpoint to query the price of a product
 * based on its identifier, the brand identifier, and the application date.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PriceController {

    private final PriceService priceService;

    /**
     * Method to retrieve the price of a product.
     *
     * @param brandId        Brand identifier.
     * @param productId      Product identifier.
     * @param applicationDate Date and time of price application.
     * @return ResponseEntity with the found price or an error.
     */

    @GetMapping("/price")
    public ResponseEntity<PriceResponse> getPrice(
            @RequestParam @NotNull int brandId,
            @RequestParam @NotNull int productId,
            @RequestParam @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate) {

        PriceResponse price = priceService.getPrice(productId, brandId, applicationDate);
        return ResponseEntity.ok(price);
    }

}
