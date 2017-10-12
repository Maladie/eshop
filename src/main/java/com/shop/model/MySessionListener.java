package com.shop.model;

import com.shop.repository.impl.ProductRepositoryImpl;
import com.shop.service.ProductService;
import com.shop.service.SessionShoppingBasketHandler;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("A new session is created");
        BasketDto basket = ProductService.productService(ProductRepositoryImpl.aProductRepository()).getBasketDto(event.getSession());
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("session is destroyed");
    }
}