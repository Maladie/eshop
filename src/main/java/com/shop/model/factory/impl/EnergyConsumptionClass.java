package com.shop.model.factory.impl;

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

    public static EnergyConsumptionClass parseEClass(String eclass) {
        return EnergyConsumptionClass.valueOf(eclass);
    }
}
