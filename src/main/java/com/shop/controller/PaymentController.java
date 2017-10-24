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

@WebServlet(name = "Payment", value = "/payment")
public class PaymentController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BasketDto basketDto = BasketService.basketService().getBasketDto(req.getSession());
    }
}
