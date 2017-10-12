package com.shop.model;

import com.shop.model.factory.impl.Product;
import com.shop.repository.impl.ProductRepositoryImpl;
import com.shop.service.ProductService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BasketDto {

    List<ProductDto> productDtoList;

    public BasketDto(){
        productDtoList = new ArrayList<>();
    }

    public List<ProductDto> getProductDtoList() {
        return productDtoList;
    }

    public void voidProductDtoList() {
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
