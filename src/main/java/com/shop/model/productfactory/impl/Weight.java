package com.shop.model.productfactory.impl;

import javax.persistence.Embeddable;

@Embeddable
class Weight {

    private float weightValue;
    private Unit unit;

    public Weight() {
    }

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
