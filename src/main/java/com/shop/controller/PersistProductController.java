package com.shop.controller;

import com.shop.model.ProductDto;
import com.shop.model.factory.impl.ProductDtoFactory;
import com.shop.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PersistProductController", value = "/persistProduct")
public class PersistProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("addProductForm.jsp").forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDto productDto =  ProductDtoFactory.getProductDtoForNewProduct(request);
        ProductService.productService().persistProduct(productDto);
        response.sendRedirect("/");
    }
}
