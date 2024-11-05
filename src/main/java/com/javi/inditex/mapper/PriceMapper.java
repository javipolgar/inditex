package com.javi.inditex.mapper;

import com.javi.inditex.model.dto.PriceResponse;
import com.javi.inditex.model.entity.PriceEntity;

public class PriceMapper {

    public static PriceResponse toDto(PriceEntity entity){
        PriceResponse response = new PriceResponse();
        response.setBrandId(entity.getBrandId());
        response.setPriceList(entity.getPriceList());
        response.setProductId(entity.getProductId());
        response.setStartDate(entity.getStartDate());
        response.setEndDate(entity.getEndDate());
        response.setPrice(entity.getPrice());
        return response;
    }
}
