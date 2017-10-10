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
        int productId = Integer.parseInt(request.getParameter("productId"));
        Basket basket = SessionShoppingBasketHandler.retrieveBasket(request.getSession());
        ProductService.productService(ProductRepositoryImpl.aProductRepository()).addProductToBasket(basket, productId);
        
    }
}
