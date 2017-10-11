package com.shop.service;

import com.shop.model.Basket;;
import com.shop.model.factory.ProductFactory;
import com.shop.model.factory.impl.Product;
import com.shop.model.factory.impl.ProductFactoryImpl;
import com.shop.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;

public class ProductServiceTest {

    public static final String SAMPLE = "SAMPLE";
    public static final BigDecimal VALUE = new BigDecimal(10);
    public static final String CURRENCY = "PLN";
    public static final String FULL_DESCRIPTION = "FULL DESC";

    private ProductRepository productRepository;


    @InjectMocks
    private ProductService productService;

    @Before
    public void setUp(){
        productRepository = Mockito.mock(ProductRepository.class);
        productService = ProductService.productService(productRepository);
    }



//    public void shouldNewShoppingCartContainOneProductIfUserAddProductToShoppingCart() {
//        //given
//        int productId = 10;
//        Basket shoppingCart = new Basket();
//        Mockito.when(productRepository.getProductById(productId)).thenReturn(aSimpleProduct());
//        //when
//        productService.addProductToBasket(shoppingCart,10);
//        //then
//        Assert.assertEquals("The size of the shopping cart should be 1", 1,shoppingCart.getBasketSize());
//    }
//
//
//    public void shouldQuantityIncreaseWhenTheSameProductAddedToBasket(){
//        //given
//        int productId = 0;
//        Basket basket = new Basket();
//        Mockito.when(productRepository.getProductById(productId)).thenReturn(aSimpleProduct());
//        //when
//        productService.addProductToBasket(basket, 0);
//        productService.addProductToBasket(basket, 0);
//        //then
//        Assert.assertEquals("The Quantity of products should be 2", 2, basket.getProductItemQuantity(0));
//    }


    private Product aSimpleProduct(){
        ProductFactory factory = new ProductFactoryImpl();
        return factory.newProduct(SAMPLE, VALUE, CURRENCY, FULL_DESCRIPTION);
    }

}