package com.shop.model.factory.impl;

import java.math.BigDecimal;

public class Product {

    private int id;
    private String description;
    private String brand;
    private Money money;
    private Weight weight;
    private EnergyConsumptionClass EClass;

    Product(int id,
            String description,
            String brand,
            BigDecimal value,
            String currency,
            float weightValue,
            Unit unit,
            EnergyConsumptionClass EClass) {
        this.id = id;
        this.description = description;
        this.brand = brand;
        this.money = new Money(value, currency);
        this.weight = new Weight(weightValue, unit);
        this.EClass = EClass;

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

    public String getBrand() {
        return brand;
    }

    public float getWeightValue() {
        return weight.getWeightValue();
    }

    public Unit getWeightUnit() { return weight.getUnit(); }

    public EnergyConsumptionClass getEClass() {
        return EClass;
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

    public void setBrand(String brand) {
        if(!brand.equals("")){
            this.brand = brand;
        }
    }

    public void setWeightValue(float weight) {
        this.weight.setWeightValue(weight);
    }

    public void setWeightUnit(Unit unit) {
        this.weight.setUnit(unit);
    }

    public void setEClass(EnergyConsumptionClass EClass) {
        this.EClass = EClass;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", money=" + money +
                ", brand='" + brand + '\'' +
                ", weight=" + weight +
                ", EClass=" + EClass +
                '}';
    }
}
