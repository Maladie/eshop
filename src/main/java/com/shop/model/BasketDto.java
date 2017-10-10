package com.shop.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BasketDto {

    List<ProductDto> productDtoList;
    private Basket basket;

    public BasketDto(Basket basket){
        productDtoList = new ArrayList<>();
        this.basket = basket;
        updateBasket();
    }

    private void updateBasket() {
        basket.productItemList().forEach(p -> {ProductDto productDto = new ProductDto(p);
            productDtoList.add(productDto);
        });
    }

    public List<ProductDto> getProductDtoList() {
        return productDtoList;
    }

    public void voidProductDtoList() {
        basket.voidBasket();
        productDtoList.clear();
    }

    public BigDecimal getTotal(){
        BigDecimal sum = new BigDecimal(0);
        for (ProductDto productDto : productDtoList) {
            sum = sum.add(productDto.getValue());
        }
        return sum;
    }
}
