package com.shop.model.factory.impl;

import java.math.BigDecimal;

class Money {

    private BigDecimal value;
    private String currency;

    public Money() {
    }

    Money(BigDecimal value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    BigDecimal getValue() {
        return value;
    }

    String getCurrency() {
        return currency;
    }

    void setValue(BigDecimal value) {
        this.value = value;
    }

    void setCurrency(String currency) {
        this.currency = currency;
    }
}
