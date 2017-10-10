package com.shop.model;

import java.math.BigDecimal;
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

    public BigDecimal getTotal(){
        BigDecimal sum = new BigDecimal(0);
        for (ProductDto productDto : productDtoList) {
            sum.add(productDto.getValue());
        }
        return sum;
    }
}
