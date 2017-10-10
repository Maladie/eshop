package com.shop.model;

import com.shop.model.factory.impl.Product;
import com.shop.repository.impl.ProductRepositoryImpl;
import com.shop.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ViewedProductsList {
    private List<Product> productsList;
    private int maxStoredProducts = 4;

    public ViewedProductsList() {
        productsList = new ArrayList<>();
    }


    public void addToViewedList(Product product) {
        if (!productsList.contains(product)) {
            productsList.add(0, product);
            if (productsList.size() > maxStoredProducts) {
                productsList.remove(maxStoredProducts - 1);
            }
        } else {
            productsList.remove(product);
            addToViewedList(product);
        }
    }

    public List<Product> getViewedProducts() {
        return productsList;
    }
}
