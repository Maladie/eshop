package com.shop.model;

import com.shop.model.factory.impl.Product;

import javax.persistence.*;
import java.math.BigDecimal;

class ProductItem {

    private int id;
    private Product product;
    private int quantity;

    private Basket basket;

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

    public void setBasket(Basket basket){
        this.basket = basket;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
