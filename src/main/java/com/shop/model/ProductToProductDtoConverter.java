package com.shop.model;

import com.shop.model.factory.impl.Product;

public class ProductToProductDtoConverter {

    public static ProductDto convert(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName();
    }
}
