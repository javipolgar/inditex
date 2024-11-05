package com.javi.inditex.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class PriceBase {
    @NotNull
    private int brandId;
    @NotNull
    private int productId;
    @NotNull
    private int priceList;
    @NotNull
    private BigDecimal price;
    @NotNull
    private LocalDateTime startDate;
    @NotNull
    private LocalDateTime endDate;
}