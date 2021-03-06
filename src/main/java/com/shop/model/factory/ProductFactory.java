package com.shop.model.factory;

import com.shop.model.factory.impl.Product;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

public interface ProductFactory {

    Product getProductUpdateTemplate(HttpServletRequest request, String filePath);

    Product newProduct(HttpServletRequest request, String filePath);
}
