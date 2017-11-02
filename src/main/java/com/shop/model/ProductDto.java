package com.shop.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ProductDto {

    private int id;
    private String title;
    private String currency;
    private BigDecimal value;
    private int quantity;
    private String description;
    private Map<String, Object> parametersMap;
    private int productAmount;
    private String imagePath;

    {
        quantity = 1;
        parametersMap = new HashMap<>();
    }

    public ProductDto(ProductItem productItem) {
        this.id = productItem.getProduct().getId();
        this.title = productItem.getProduct().getTitle();
        this.currency = productItem.getProduct().getCurrency();
        this.value = productItem.value();
        this.quantity = productItem.getQuantity();
        this.productAmount = productItem.getProduct().getProductAmount();
        this.imagePath = productItem.getProduct().getImagePath();
    }

    public ProductDto() {
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
