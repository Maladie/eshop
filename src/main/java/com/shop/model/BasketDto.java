package com.shop.model;

import java.util.ArrayList;
import java.util.List;

public class BasketDto {

    List<ProductDto> productDtoList;

    public BasketDto(Basket basket){
        productDtoList = new ArrayList<>();
        basket.productItemList().forEach(p -> {ProductDto productDto = new ProductDto(p);
            productDtoList.add(productDto);
        });
    }

    public List<ProductDto> getProductDtoList() {
        return productDtoList;
    }
}
