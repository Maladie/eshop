package com.shop.model.productfactory.impl;

public enum EnergyConsumptionClass {

    AAA("AAA"),
    AA("AA"),
    A("A"),
    B("B"),
    C("C"),
    D("D");

    private String symbol;

    EnergyConsumptionClass(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
