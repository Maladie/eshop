package com.shop.model.factory.impl;

import com.shop.model.factory.ProductFactory;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

public class ProductFactoryImpl implements ProductFactory {

    @Override
    public Product getProductUpdateTemplate(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id"));

        Product product = newProduct(request);
        product.setId(id);
        return product;
    }

    @Override
    public Product newProduct(HttpServletRequest request) {
        Product product = new Product();

        //Get parameters from HttpServletRequest
        String name = request.getParameter("name");
        BigDecimal value = setValueIfNotEmpty(request);
        String currency = request.getParameter("currency");
        String description = request.getParameter("description");
        int productAmount = Integer.valueOf(request.getParameter("amount"));
        String brand = request.getParameter("brand");
        Float weight = setWeightIfNotEmpty(request);
        Unit weightUnit = Unit.parseUnit(request.getParameter("weightunit"));
        EnergyConsumptionClass eclass = EnergyConsumptionClass.parseEClass(request.getParameter("eclass"));
        ProductCategory category = ProductCategory.parseCategory(request.getParameter("category"));

        //Set parameters to product
        product.setName(name);
        product.setValue(value);
        product.setCurrency(currency);
        product.setDescription(description);
        product.setProductAmount(productAmount);
        product.setBrand(brand);
        product.setWeightValue(weight);
        product.setWeightUnit(weightUnit);
        product.setEClass(eclass);
        product.setCategory(category);

        return product;
    }

    private BigDecimal setValueIfNotEmpty(HttpServletRequest request){
        if (!request.getParameter("value").equals("")) {
            return new BigDecimal(request.getParameter("value"));
        }
        return new BigDecimal(0);
    }

    private Float setWeightIfNotEmpty(HttpServletRequest request){
        if(!request.getParameter("weight").equals("")) {
            return Float.parseFloat(request.getParameter("weight"));
        }
        return 0f;
    }
}
