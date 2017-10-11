package com.shop.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ProductDto {

    private int id;
    private String name;
    private String currency;
    private BigDecimal value;
    private int quantity;
    private String description;
    private Map<String, Object> parametersMap;

    {
        quantity = 1;
        parametersMap = new HashMap<>();
    }

    public ProductDto(ProductItem productItem) {
        this.id = productItem.getProduct().getId();
        this.name = productItem.getProduct().getName();
        this.currency = productItem.getProduct().getCurrency();
        this.value = productItem.value();
        this.quantity = productItem.getQuantity();
    }

    public ProductDto() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Object> getParametersMap() {
        return parametersMap;
    }

    public void setParametersMap(Map<String, Object> parametersMap) {
        this.parametersMap = parametersMap;
    }
}
