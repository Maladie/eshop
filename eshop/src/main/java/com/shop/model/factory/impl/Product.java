package com.shop.model.factory.impl;

import java.math.BigDecimal;

public class Product {

    private int id;
    private String description;
    private Money money;
    private String fullDescription;

    Product(int id, String description, BigDecimal value, String currency, String fullDescription) {
        this.id = id;
        this.description = description;
        this.money = new Money(value, currency);
        this.fullDescription = fullDescription;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getValue() {
        return money.getValue();
    }

    public String getCurrency() {
        return money.getCurrency();
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setDescription(String description) {
        if(!description.equals("")) {
            this.description = description;
        }
    }

    public void setValue(BigDecimal value) {
        if(value != null) {
            this.money.setValue(value);
        }
    }

    public void setCurrency(String currency){
        if(!currency.equals("")){
            this.money.setCurrency(currency);
        }
    }

    public void setFullDescription(String fullDescription) {
        if(!fullDescription.equals("")) {
            this.fullDescription = fullDescription;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", money=" + money +
                ", fullDescription='" + fullDescription + '\'' +
                '}';
    }
}
