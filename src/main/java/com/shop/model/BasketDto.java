package com.shop.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BasketDto {
    private LocalDateTime submitDate;

    public LocalDateTime getSubmitDate() {
        return submitDate;
    }

    void setSubmitDate(LocalDateTime submitDate) {
        this.submitDate = submitDate;
    }

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
