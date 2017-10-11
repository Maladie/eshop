package com.shop.controller;

import com.shop.model.Basket;
import com.shop.model.BasketDto;
import com.shop.service.SessionShoppingBasketHandler;

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
        BasketDto basketDto = SessionShoppingBasketHandler.retrieveBasket(request.getSession());
        basketDto.removeProductFromBasket(productId);
        response.sendRedirect("/basket");
    }
}
