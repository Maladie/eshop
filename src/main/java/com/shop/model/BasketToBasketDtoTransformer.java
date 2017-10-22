package com.shop.model;

import java.util.List;

public class BasketToBasketDtoTransformer {

    public static BasketDto transformToBasketDto(Basket basket){
        BasketDto basketDto = new BasketDto();
        List<ProductDto> productDtoList = basketDto.getProductDtoList();
        basket.productItemList().forEach(p -> {ProductDto productDto = new ProductDto(p);
            productDtoList.add(productDto);
        });
        basketDto.setSubmitDate(basket.getSubmitDate());
        return basketDto;
    }
}
