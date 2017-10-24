package com.shop.controller;

import com.shop.model.BasketDto;
import com.shop.service.BasketService;
import com.shop.service.ProductService;

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
        BasketDto basketDto = BasketService.basketService().getBasketDto(request.getSession());
        request.setAttribute("basket", basketDto);
        request.getRequestDispatcher("basket.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BasketService basketService = BasketService.basketService();
        basketService.removeAllProductsFromBasket(req.getSession());
        resp.sendRedirect("/basket");
    }
}
