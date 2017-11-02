package com.shop.model.factory.impl;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Embedded
    private Author author;
    @Embedded
    private Money money;
    private String description;
    @Enumerated(EnumType.STRING)
    private ProductCategory category;
    private String ISBN10;
    private String ISBN13;
    private int productAmount;
    private String imagePath;

    public Product() {
        money = new Money();
        productAmount = 0;
    }

    public String getISBN10() {
        return ISBN10;
    }

    public void setISBN10(String ISBN10) {
        this.ISBN10 = ISBN10;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return money.getValue();
    }

    public void setValue(BigDecimal value) {
        if (value != null) {
            this.money.setValue(value);
        }
    }

    public String getCurrency() {
        return money.getCurrency();
    }

    public void setCurrency(String currency) {
        if (!currency.equals("")) {
            this.money.setCurrency(currency);
        }
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getISBN13() {
        return ISBN13;
    }

    public void setISBN13(String ISBN) {
        this.ISBN13 = ISBN;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", money=" + money +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", productAmount=" + productAmount +
                '}';
    }
}
