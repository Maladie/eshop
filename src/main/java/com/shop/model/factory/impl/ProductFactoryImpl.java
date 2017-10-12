package com.shop.model.factory.impl;

import com.shop.model.factory.ProductFactory;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

public class ProductFactoryImpl implements ProductFactory {

    private static int PRODUCTCOUNTER = 0;

    @Override
    public Product getProductUpdateTemplate(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("description");
        BigDecimal value = null;
        if (!request.getParameter("value").equals("")) {
            value = BigDecimal.valueOf(Long.parseLong(request.getParameter("value")));
        }
        String currency = request.getParameter("currency");
        String fullDescription = request.getParameter("fullDescription");
        //TODO temp
        return new Product(id, name, "brand_Factory", fullDescription, value, currency, 1f, Unit.TONES,EnergyConsumptionClass.D, ProductCategory.WASHING_MACHINE);
        // new Product(id, description, value, currency, fullDescription);
    }

    @Override
    public Product newProduct(HttpServletRequest request) {
        int id = PRODUCTCOUNTER++;
        String name = request.getParameter("description");
        BigDecimal value = new BigDecimal(0);
        try {
            value = BigDecimal.valueOf(Long.parseLong(request.getParameter("value")));
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
        String currency = request.getParameter("currency");
        String fullDescription = request.getParameter("fullDescription");
        //TODO temp
        return new Product(id, name, "brand_Factory", fullDescription, value, currency, 1f, Unit.TONES,EnergyConsumptionClass.D, ProductCategory.WASHING_MACHINE);
    }

    @Override
    public Product newProduct(String name, BigDecimal value, String currency, String fullDescription) {
        //TODO temp
        return new Product(PRODUCTCOUNTER++, name, "brand_Factory", fullDescription, value, currency, 1f, Unit.TONES,EnergyConsumptionClass.D, ProductCategory.WASHING_MACHINE);
    }
}
