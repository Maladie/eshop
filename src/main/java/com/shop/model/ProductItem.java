package com.shop.model;

import com.shop.model.productfactory.impl.Product;

import java.math.BigDecimal;

class ProductItem {
    private Product product;
    private int quantity;

    public ProductItem(Product product) {
        this.product = product;
        this.quantity = new Integer(1);
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void incrementQuantify(){
        quantity++;
    }

    public BigDecimal value(){
        BigDecimal bigDecimalQuantity = BigDecimal.valueOf(quantity);
        return product.getValue().multiply(bigDecimalQuantity);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
