package com.shop.controller;

import com.shop.model.BasketDto;
import com.shop.model.SubmittedBasketsList;
import com.shop.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="SubmitBasket", value="/basketHistory")
public class SubmitBasketController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = ProductService.productService();
        HttpSession currentSession = req.getSession();
        BasketDto basket = productService.getBasketDto(currentSession);
        SubmittedBasketsList submittedBasketsList = SubmittedBasketsList.getInstance();
        RequestDispatcher dispatcher = req.getRequestDispatcher("baskethistory.jsp");
        req.setAttribute("submittedBaskets", submittedBasketsList);

        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = ProductService.productService();
        HttpSession currentSession = req.getSession();
        BasketDto basket = productService.getBasketDto(currentSession);
        SubmittedBasketsList submittedBasketsList = SubmittedBasketsList.getInstance();
        submittedBasketsList.addToSubmittedBaskets(basket);

        RequestDispatcher dispatcher = req.getRequestDispatcher("baskethistory.jsp");
        req.setAttribute("submittedBaskets", submittedBasketsList);
        dispatcher.forward(req, resp);

        ProductService.productService().removeAllProductsFromBasket(req.getSession());
    }
}
