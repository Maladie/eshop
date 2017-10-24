package com.shop.repository;

import com.shop.model.Basket;
import com.shop.model.BasketDto;
import com.shop.model.userfactory.impl.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface BasketRepository {

    void submitBasket(String username, Basket basket);

    List<Basket> getBasketList();

    List<Basket> getBasketListByUsername(String username);
}
