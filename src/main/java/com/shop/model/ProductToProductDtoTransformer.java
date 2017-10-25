package com.shop.model;

import com.shop.model.factory.impl.Product;
import java.util.Map;

public class ProductToProductDtoTransformer {

    public static ProductDto transform(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setCurrency(product.getCurrency());
        productDto.setValue(product.getValue());
        productDto.setDescription(product.getDescription());
        productDto.setProductAmount(product.getProductAmount());
        productDto.setImagePath(product.getImagePath());

        Map<String, Object> parametersMap = productDto.getParametersMap();
        parametersMap.put("author", product.getAuthor());
        parametersMap.put("isbn13",product.getISBN13());
        parametersMap.put("category", product.getCategory());

        return productDto;
    }
}
