package com.shop.model.productfactory;

import com.shop.model.productfactory.impl.Product;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

public interface ProductFactory {
    Product getProductUpdateTemplate(HttpServletRequest request);

    Product newProduct(HttpServletRequest request);

    Product newProduct(String description, BigDecimal value, String currency, String fullDescription);
}
