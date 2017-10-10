package com.shop.controller;

import com.shop.model.Basket;
import com.shop.model.factory.impl.Product;
import com.shop.repository.impl.ProductRepositoryImpl;
import com.shop.service.ProductService;
import com.shop.service.SessionShoppingBasketHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addToBasket", value = "/addProduct")
public class AddToBasketController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productIdParam = request.getParameter("productId");
        System.out.println(productIdParam);
        int productId = Integer.parseInt(productIdParam);

        Basket basket = SessionShoppingBasketHandler.retrieveBasket(request.getSession());
        if(basket == null){
            System.out.println("basket is null");
        }
        ProductService productService = ProductService.productService(ProductRepositoryImpl.aProductRepository());
        if(productService.getProductById(productId) == null) {
            System.out.println("produkt o id: " + productId + " nie moze zostac pobrany z repozytornium");
        }
        productService.addProductToBasket(basket,productId);

        System.out.println("dodano do koszyka");

        response.sendRedirect("/");
    }
}
