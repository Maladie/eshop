package com.shop.model;

import com.shop.model.factory.impl.Product;

import java.util.List;

public class BasketToBasketDtoConverter {

    public static BasketDto convertToBasketDto(Basket basket){
        BasketDto basketDto = new BasketDto();
        List<ProductDto> productDtoList = basketDto.getProductDtoList();
        basket.productItemList().forEach(p -> {ProductDto productDto = new ProductDto(p);
            productDtoList.add(productDto);
        });
        return basketDto;
    }

    public static Basket convertToBasket(BasketDto basketDto){
        Basket basket = new Basket();
        basketDto.getProductDtoList().forEach(productDto -> {
           Product product = ProductToProductDtoConverter.convertToProduct(productDto);
            ProductItem productItem = new ProductItem(product);
            productItem.setQuantity(productDto.getQuantity());
            basket.productItemList().add(productItem);
        });
        return basket;
    }
}
