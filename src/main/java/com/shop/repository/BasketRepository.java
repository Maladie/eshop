package com.shop.repository;

import com.shop.model.Basket;
import com.shop.model.userfactory.impl.User;

public interface BasketRepository {

    void submitBasket(int userId, Basket basket);
}
