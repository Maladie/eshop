package com.shop.model;

import com.shop.model.factory.impl.EnergyConsumptionClass;
import com.shop.model.factory.impl.Product;
import com.shop.model.factory.impl.ProductCategory;
import com.shop.model.factory.impl.Unit;

import java.util.Map;

public class ProductToProductDtoTransformer {

    public static ProductDto transformToDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setCurrency(product.getCurrency());
        productDto.setValue(product.getValue());
        productDto.setDescription(product.getDescription());
        productDto.setProductAmount(product.getProductAmount());

        Map<String, Object> parametersMap = productDto.getParametersMap();
        parametersMap.put("weightValue", product.getWeightValue());
        parametersMap.put("weightUnit", product.getWeightUnit());
        parametersMap.put("brand", product.getBrand());
        parametersMap.put("eclass", product.getEClass());
        parametersMap.put("category", product.getCategory());

        return productDto;
    }

    public static Product transformToProduct(ProductDto productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setValue(productDto.getValue());
        product.setDescription(productDto.getDescription());
        product.setCurrency(productDto.getCurrency());
        product.setProductAmount(productDto.getProductAmount());

        Map<String, Object> parametersMap = productDto.getParametersMap();
        product.setBrand((String) parametersMap.get("brand"));
        product.setWeightValue((Float) parametersMap.get("weightValue"));
        product.setWeightUnit((Unit) parametersMap.get("weightUnit"));
        product.setEClass((EnergyConsumptionClass) parametersMap.get("eclass"));
        product.setCategory((ProductCategory) parametersMap.get("category"));

        return product;
    }
}
