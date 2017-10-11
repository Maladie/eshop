package com.shop.model.factory.impl;

public class Weight {

    private float weightValue;
    private Unit unit;

    public Weight(float value, Unit unit) {
        this.weightValue = value;
        this.unit = unit;
    }

    public float getWeightValue() {
        return weightValue;
    }

    public void setWeightValue(float weightValue) {
        this.weightValue = weightValue;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
