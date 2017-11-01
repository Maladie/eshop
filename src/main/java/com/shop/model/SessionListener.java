package com.shop.model;

import com.shop.service.BasketService;
import com.shop.service.ProductService;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("A new session is created");
        BasketDto basketDto = BasketService.basketService().getBasketDto(event.getSession());
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("session is destroyed");
    }
}