package com.shop.model;

import com.shop.model.factory.impl.Product;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ProductItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private Product product;
    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    private Basket basket;

    public ProductItem(Product product) {
        this.product = product;
        this.quantity = new Integer(1);
    }

    public ProductItem() {
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
