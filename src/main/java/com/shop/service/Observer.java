package com.shop.service;

import com.shop.model.productfactory.impl.Product;

public interface Observer {
    void update(String actionDescr, Product product);
}
