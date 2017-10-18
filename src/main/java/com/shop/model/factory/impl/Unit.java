package com.shop.model.factory.impl;

public enum Unit {
    GRAMS,
    KILOGRAMS,
    TONES;

    public static Unit parseUnit(String weightUnit) {
        return Unit.valueOf(weightUnit);
    }
}
