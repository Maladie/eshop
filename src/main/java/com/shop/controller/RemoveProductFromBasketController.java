package com.shop.controller;

import com.shop.service.BasketService;
import com.shop.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "removeProduct", value = "/removeProduct")
public class RemoveProductFromBasketController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int productId = Integer.parseInt(request.getParameter("productId"));
        BasketService basketService = BasketService.basketService();
        basketService.removeProductFromBasket(request.getSession(), productId);
        response.sendRedirect("/basket");
    }
}
