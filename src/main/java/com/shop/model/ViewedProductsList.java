package com.shop.model;

import com.shop.model.factory.impl.Product;
import com.shop.repository.impl.ProductRepositoryImpl;
import com.shop.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ViewedProductsList {
    private List<ProductDto> productsList;
    private final int maxStoredProducts = 4;

    public ViewedProductsList() {
        productsList = new ArrayList<>();
    }


    public void addToViewedList(ProductDto product) {
        if (!productsList.contains(product)) {
            productsList.add(0, product);
            if (productsList.size() > maxStoredProducts) {
                productsList.remove(maxStoredProducts - 1);
            }
        } else {
            productsList.remove(product);
            //TODO do przerobienia
            addToViewedList(product);
        }
    }

    public List<ProductDto> getViewedProducts() {
        return productsList;
    }
}
