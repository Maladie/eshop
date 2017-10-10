package com.shop.service;

import com.shop.model.factory.impl.Product;

public interface Observer {
    void update(String actionDescr, Product product);
}
