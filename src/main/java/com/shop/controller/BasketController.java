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

@WebServlet(name = "Basket", value = "/basket")
public class BasketController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BasketDto basketDto = SessionShoppingBasketHandler.retrieveBasket(request.getSession());
        request.setAttribute("basket", basketDto);
        request.getRequestDispatcher("basket.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BasketDto basketDto = SessionShoppingBasketHandler.retrieveBasket(req.getSession());
        basketDto.voidProductDtoList();
        resp.sendRedirect("/basket");
    }
}
