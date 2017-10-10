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
        this.value = productItem.value();
        this.quantity = productItem.getQuantity();
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public int getQuantity() {
        return quantity;
    }
}
