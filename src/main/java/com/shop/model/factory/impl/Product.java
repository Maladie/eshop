package com.shop.model.factory.impl;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String brand;
    //TODO TEMP
    @Transient
    private Money money;
    @Transient
    private Weight weight;
    private EnergyConsumptionClass EClass;
    private String description;

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    private int productAmount;

    public Product() {
        money = new Money();
        weight = new Weight();
        productAmount = 10;
    }

    Product(int id,
            String name,
            String brand,
            String description,
            BigDecimal value,
            String currency,
            float weightValue,
            Unit unit,
            EnergyConsumptionClass EClass) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.money = new Money(value, currency);
        this.weight = new Weight(weightValue, unit);
        this.EClass = EClass;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public Unit getWeightUnit() {
        return weight.getUnit();
    }

    public Weight getWeight(){
        return weight;
    }

    public String getEClassSymbol() {
        return EClass.getSymbol();
    }

    public Money getMoney() {
        return money;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public EnergyConsumptionClass getEClass() {
        return EClass;
    }

    public void setName(String name) {
        if (!name.equals("")) {
            this.name = name;
        }
    }

    public void setValue(BigDecimal value) {
        if (value != null) {
            this.money.setValue(value);
        }
    }

    public void setCurrency(String currency) {
        if (!currency.equals("")) {
            this.money.setCurrency(currency);
        }
    }

    public void setBrand(String brand) {
        if (!brand.equals("")) {
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
                ", name='" + name + '\'' +
                ", money=" + money +
                ", brand='" + brand + '\'' +
                ", weight=" + weight +
                ", EClass=" + EClass +
                '}';
    }
}
