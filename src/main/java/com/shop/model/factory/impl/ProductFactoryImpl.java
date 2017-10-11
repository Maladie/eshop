package com.shop.model.factory.impl;

import com.shop.model.factory.ProductFactory;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

public class ProductFactoryImpl implements ProductFactory {

    private static int PRODUCTCOUNTER = 0;

    @Override
    public Product getProductUpdateTemplate(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id"));
        String description = request.getParameter("description");
        BigDecimal value = null;
        if (!request.getParameter("value").equals("")) {
            value = BigDecimal.valueOf(Long.parseLong(request.getParameter("value")));
        }
        String currency = request.getParameter("currency");
        String fullDescription = request.getParameter("fullDescription");
        return null;// new Product(id, description, value, currency, fullDescription);
    }

    @Override
    public Product newProduct(HttpServletRequest request) {
        int id = PRODUCTCOUNTER++;
        String description = request.getParameter("description");
        BigDecimal value = new BigDecimal(0);
        try {
            value = BigDecimal.valueOf(Long.parseLong(request.getParameter("value")));
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
        String currency = request.getParameter("currency");
        String fullDescription = request.getParameter("fullDescription");
        return null;
    }

    @Override
    public Product newProduct(String description, BigDecimal value, String currency, String fullDescription) {
        return null;
    }
}
