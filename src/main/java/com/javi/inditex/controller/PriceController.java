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
 * Controlador para manejar las solicitudes relacionadas con los precios.
 * Este controlador proporciona un endpoint REST para consultar el precio de un producto
 * basado en su identificador, el identificador de la marca y la fecha de aplicación.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PriceController {

    private final PriceService priceService;

    /**
     * Método para obtener el precio de un producto.
     *
     * @param brandId        Identificador de la marca.
     * @param productId      Identificador del producto.
     * @param applicationDate Fecha y hora de aplicación del precio.
     * @return ResponseEntity con el precio encontrado o un error.
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
