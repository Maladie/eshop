package com.shop.model.factory.impl;

import com.shop.model.ProductDto;
import com.shop.model.factory.ProductFactory;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Map;

public class ProductDtoFactory {

    public static ProductDto getProductDto(HttpServletRequest request) {
//        //
//        int id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        BigDecimal value = null;
        if (!request.getParameter("value").equals("")) {
            value = BigDecimal.valueOf(Long.parseLong(request.getParameter("value")));
        }
        String currency = request.getParameter("currency");
        String description = request.getParameter("description");
        //optional values
        String brand = "brand_temp";
        if (request.getParameter("brand") != null) {
            brand = request.getParameter("brand");
        }
        Float weight = 1.0f;
        if(request.getParameter("weight") !=null) {
            weight = Float.parseFloat(request.getParameter("weight"));
        }
        Unit weightUnit = parseUnit(request.getParameter("weightunit"));
        EnergyConsumptionClass eclass = parseEClass(request.getParameter("eclass"));


        ProductDto productDto =new ProductDto();
//        productDto.setId(id);
        productDto.setName(name);
        productDto.setValue(value);
        productDto.setCurrency(currency);
        productDto.setDescription(description);

        Map<String, Object> parametersMap = productDto.getParametersMap();
        parametersMap.put("weightValue", weight);
        parametersMap.put("weightUnit", weightUnit);
        parametersMap.put("brand", brand);
        parametersMap.put("eclass", eclass);
        productDto.setParametersMap(parametersMap);

        return productDto;
    }

    private static EnergyConsumptionClass parseEClass(String eclass) {
        if(eclass == null){
            eclass = "A";
        }
        return EnergyConsumptionClass.valueOf(eclass);
    }

    private static Unit parseUnit(String weightUnit) {
        if(weightUnit == null){
            weightUnit = "TONES";
        }
        return Unit.valueOf(weightUnit);
    }

    public static ProductDto createProduct(HttpServletRequest request) {
        return getProductDto(request);
    }
}
