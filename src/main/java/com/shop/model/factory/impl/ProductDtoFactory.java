package com.shop.model.factory.impl;

import com.shop.model.ProductDto;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Map;

public class ProductDtoFactory {

    private static int ID = 100;

    public static ProductDto getProductDtoForNewProduct(HttpServletRequest request) {

        String title = request.getParameter("title");
        BigDecimal value = new BigDecimal(0);
        if (!request.getParameter("value").equals("")) {
            value = new BigDecimal(request.getParameter("value"));
        }
        String currency = request.getParameter("currency");
        String description = request.getParameter("description");
        int productAmount = Integer.valueOf(request.getParameter("amount"));
        Author author = getAuthor(request);
        long isbn13 = Long.parseLong(request.getParameter("isbn13"));
        ProductCategory category = parseCategory(request.getParameter("category"));

        ProductDto productDto = new ProductDto();
        productDto.setTitle(title);
        productDto.setValue(value);
        productDto.setCurrency(currency);
        productDto.setDescription(description);
        productDto.setProductAmount(productAmount);

        Map<String, Object> parametersMap = productDto.getParametersMap();
        parametersMap.put("author", author);
        parametersMap.put("isbn13", isbn13);
        parametersMap.put("category", category);
        productDto.setParametersMap(parametersMap);

        return productDto;
    }

    private static Author getAuthor(HttpServletRequest request) {
        String authorName = request.getParameter("authorName");
        String authorSurname = request.getParameter("authorSurname");
        return new Author(authorName, authorSurname);
    }

    private static ProductCategory parseCategory(String category) {
        ProductCategory productCategory = ProductCategory.OTHER;
        if(category != null){
            productCategory = ProductCategory.valueOf(category);
        }
        return productCategory;
    }

    public static ProductDto getProductDtoForEditedProduct(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductDto updatedDto = getProductDtoForNewProduct(request);
        updatedDto.setId(id);
        return updatedDto;
    }
}
