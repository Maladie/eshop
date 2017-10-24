package com.shop.model;

import com.shop.model.factory.impl.EnergyConsumptionClass;
import com.shop.model.factory.impl.Product;
import com.shop.model.factory.impl.ProductCategory;
import com.shop.model.factory.impl.Unit;

import java.util.Map;

public class ProductToProductDtoTransformer {

    public static ProductDto transform(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setCurrency(product.getCurrency());
        productDto.setValue(product.getValue());
        productDto.setDescription(product.getDescription());
        productDto.setProductAvailability(product.getProductAvailability());

        Map<String, Object> parametersMap = productDto.getParametersMap();
        parametersMap.put("weightValue", product.getWeightValue());
        parametersMap.put("weightUnit", product.getWeightUnit());
        parametersMap.put("brand", product.getBrand());
        parametersMap.put("eclass", product.getEClass());
        parametersMap.put("category", product.getCategory());

        return productDto;
    }
}
