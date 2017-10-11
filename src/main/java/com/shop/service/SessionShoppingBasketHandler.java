package com.shop.service;

import com.shop.model.Basket;
import com.shop.model.BasketDto;
import com.shop.model.BasketToBasketDtoConverter;

import javax.servlet.http.HttpSession;

public class SessionShoppingBasketHandler {

    public static BasketDto retrieveBasket(HttpSession session){
        if(session.getAttribute("basket") == null) {
            session.setAttribute("basket", new Basket());
        }
        return BasketToBasketDtoConverter.convertToBasketDto((Basket) session.getAttribute("basket"));
    }
}
