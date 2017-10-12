package com.shop.model.factory.impl;

public enum ProductCategory {

    DISHWASHER("DISHWASHER"),
    FREEZER("FREEZER"),
    KETTLE("KETTLE"),
    MICROWAVE_OVEN("MICROWAVE_OVEN"),
    OVEN("OVEN"),
    REFRIGERATOR("REFRIGERATOR"),
    WASHING_MACHINE("WASHING_MACHINE");

    private String category;

    ProductCategory(String category) {
        this.category = category;
    }


}
