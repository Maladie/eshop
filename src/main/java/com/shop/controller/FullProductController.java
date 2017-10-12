package com.shop.controller;

import com.shop.model.ProductDto;
import com.shop.model.ViewedProductsList;
import com.shop.model.factory.impl.Product;
import com.shop.repository.impl.ProductRepositoryImpl;
import com.shop.service.ProductService;
import com.shop.service.SessionLastProductViewedHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FullProductController", value = "/productDescription")
public class FullProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        int id = Integer.parseInt(httpServletRequest.getParameter("product"));
        ProductDto product = ProductService.productService().getProductById(id);

        //viewed products log to view
        ViewedProductsList viewedProductsList = SessionLastProductViewedHandler.retrieveViewedProductList(httpServletRequest.getSession());
        viewedProductsList.addToViewedList(product);

        httpServletRequest.setAttribute("product", product);
        httpServletRequest.getRequestDispatcher("productDescription.jsp").forward(httpServletRequest, httpServletResponse);
    }
}
