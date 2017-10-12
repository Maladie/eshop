package com.shop.controller;

import com.shop.model.ProductDto;
import com.shop.model.factory.impl.ProductDtoFactory;
import com.shop.repository.impl.ProductRepositoryImpl;
import com.shop.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Edit", value = "/edit")
public class EditProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        ProductDto product = ProductService
                .productService(ProductRepositoryImpl.aProductRepository())
                .getProductById(id);
        request.setAttribute("product", product);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDto updatedProduct = ProductDtoFactory.getProductDto(request);
        ProductService.productService(ProductRepositoryImpl.aProductRepository()).editProduct(updatedProduct);
        response.sendRedirect("/");
    }
}
