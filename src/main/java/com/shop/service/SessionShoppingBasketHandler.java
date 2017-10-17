package com.shop.service;

import com.shop.model.Basket;

import javax.servlet.http.HttpSession;

public class SessionShoppingBasketHandler {

    public static Basket retrieveBasket(HttpSession session){
        if(session.getAttribute("basket") == null) {
            session.setAttribute("basket", new Basket());
        }
        return (Basket) session.getAttribute("basket");
    }
}
