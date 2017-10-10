package com.shop.model;

import java.math.BigDecimal;

public class ProductDto {

    private int id;
    private String description;
    private String currency;
    private BigDecimal value;
    private int quantity;

    public ProductDto(ProductItem productItem) {
        this.id = productItem.getProduct().getId();
        this.description = productItem.getProduct().getDescription();
        this.currency = productItem.getProduct().getCurrency();
        this.value = productItem.getProduct().getValue();
        this.quantity = productItem.getQuantity();
    }
}
