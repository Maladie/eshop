package com.shop.controller;

import com.shop.model.Basket;
import com.shop.service.SessionShoppingBasketHandler;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Basket", value = "/basket")
public class BasketController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Basket basket = SessionShoppingBasketHandler.retrieveBasket(request.getSession());
        request.setAttribute("basket", basket);
        request.getRequestDispatcher("basket.jsp").forward(request, response);
    }
}