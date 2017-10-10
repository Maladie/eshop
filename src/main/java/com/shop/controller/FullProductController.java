package com.shop.controller;

import com.shop.model.factory.impl.Product;
import com.shop.repository.impl.ProductRepositoryImpl;
import com.shop.service.ProductService;

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
        Product product = ProductService.productService(ProductRepositoryImpl.aProductRepository()).getProductById(id);
        httpServletRequest.setAttribute("product", product);
        httpServletRequest.getRequestDispatcher("productDescription.jsp").forward(httpServletRequest, httpServletResponse);
    }
}
