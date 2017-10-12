package com.shop.model.factory.impl;

import com.shop.model.ProductDto;
import com.shop.model.factory.ProductFactory;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Map;

public class ProductDtoFactory {

    private static int ID = 100;

    public static ProductDto getProductDtoForNewProduct(HttpServletRequest request) {
        //
        String name = request.getParameter("name");
        BigDecimal value = new BigDecimal(0);
        if (!request.getParameter("value").equals("")) {
            value = BigDecimal.valueOf(Long.parseLong(request.getParameter("value")));
        }
        String currency = request.getParameter("currency");
        String description = request.getParameter("description");
        //optional values
        String brand = request.getParameter("brand");
        Float weight = 0f;
        if(!request.getParameter("weight").equals("")) {
            weight = Float.parseFloat(request.getParameter("weight"));
        }
        Unit weightUnit = parseUnit(request.getParameter("weightunit"));
        EnergyConsumptionClass eclass = parseEClass(request.getParameter("eclass"));
        ProductCategory category = parseCategory(request.getParameter("category"));


        ProductDto productDto =new ProductDto();
        productDto.setId(ID++); //TODO Trzeba dopisać żeby tworzyło ID dla kolejnego produktu
        productDto.setName(name);
        productDto.setValue(value);
        productDto.setCurrency(currency);
        productDto.setDescription(description);

        Map<String, Object> parametersMap = productDto.getParametersMap();
        parametersMap.put("weightValue", weight);
        parametersMap.put("weightUnit", weightUnit);
        parametersMap.put("brand", brand);
        parametersMap.put("eclass", eclass);
        parametersMap.put("category", category);
        productDto.setParametersMap(parametersMap);

        return productDto;
    }

    private static ProductCategory parseCategory(String category) {
        return ProductCategory.valueOf(category);
    }

    public static ProductDto getProductDtoForEditedProduct(HttpServletRequest request) {
        ProductDto updatedDto = getProductDtoForNewProduct(request);
        int id = Integer.parseInt(request.getParameter("id"));
        updatedDto.setId(id);
        return updatedDto;
    }

    private static EnergyConsumptionClass parseEClass(String eclass) {
        return EnergyConsumptionClass.valueOf(eclass);
    }

    private static Unit parseUnit(String weightUnit) {
        return Unit.valueOf(weightUnit);
    }
}
