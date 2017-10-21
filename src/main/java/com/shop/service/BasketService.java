package com.shop.service;

import com.shop.model.Basket;
import com.shop.model.BasketDto;
import com.shop.model.BasketToBasketDtoTransformer;
import com.shop.model.ProductToProductDtoTransformer;
import com.shop.model.factory.impl.Product;
import com.shop.repository.BasketRepository;
import com.shop.repository.impl.HibernateBasketRepositoryImpl;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

public class BasketService {

    private static BasketService basketService;

    private static ProductListOperationsService productService;

    private BasketRepository basketRepository;

    private BasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public static BasketService basketService() {
        if(basketService != null) {
            return basketService;
        }
        basketService = new BasketService(HibernateBasketRepositoryImpl.aBasketRepository());
        productService = ProductListOperationsService.productService();
        return basketService;
    }

    public void addProductToBasket(HttpSession session, int productId) {
        Product product = productService.getProductById(productId);
        Basket basket = SessionShoppingBasketHandler.retrieveBasket(session);
        basket.addToBasket(product);
    }

    public void removeProductFromBasket(HttpSession session, int productId) {
        Basket basket = SessionShoppingBasketHandler.retrieveBasket(session);
        Product product = productService.getProductById(productId);
        basket.removeFromBasket(product);
    }

    public void removeAllProductsFromBasket(HttpSession session) {
        Basket basket = new Basket();
        session.setAttribute("basket", basket);
    }

    public BasketDto getBasketDto(HttpSession session){
        return BasketToBasketDtoTransformer.transformToBasketDto(SessionShoppingBasketHandler.retrieveBasket(session));
    }

    public void submitBasket(HttpSession session){
        String username = (String) session.getAttribute("userName");
        Basket basket = SessionShoppingBasketHandler.retrieveBasket(session);
        basketRepository.submitBasket(username, basket);
    }


    public List<BasketDto> getSubmitedBasketsHistory(HttpSession session) {
        String username = (String) session.getAttribute("userName");
        List<Basket> basketList =  basketRepository.getBasketListByUsername(username);
        List<BasketDto> basketDtoList = transformToBasketDtoList(basketList);
        return basketDtoList;
    }

    private List<BasketDto> transformToBasketDtoList(List<Basket> basketList){
       return basketList.stream().map(basket -> BasketToBasketDtoTransformer.transformToBasketDto(basket)).collect(Collectors.toList());
    }
}
