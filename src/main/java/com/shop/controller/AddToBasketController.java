package com.shop.controller;

import com.shop.service.BasketService;
import com.shop.service.ProductListOperationsService;
import com.shop.service.ProductService;

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

        ProductListOperationsService productListOperationsService = ProductListOperationsService.productService();
        BasketService basketService = BasketService.basketService();
        if(productListOperationsService.getProductById(productId) == null) {
            System.out.println("produkt o id: " + productId + " nie moze zostac pobrany z repozytornium");
        }
        basketService.addProductToBasket(request.getSession(), productId);

        System.out.println("dodano do koszyka");

        response.sendRedirect("/");
    }
}
