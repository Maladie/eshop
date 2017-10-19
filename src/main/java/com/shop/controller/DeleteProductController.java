package com.shop.controller;

import com.shop.model.ProductDto;
import com.shop.service.ProductListOperationsService;
import com.shop.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.NoSuchElementException;

@WebServlet(name="Delete", value = "/delete")
public class DeleteProductController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductDto product = ProductListOperationsService.productService().getProductById(id);
        request.setAttribute("product", product);
        request.getRequestDispatcher("delete.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            ProductService.productService().deleteProductById(id);
            response.sendRedirect("/");
        }catch (NoSuchElementException e){
            response.sendRedirect("/");
        }
    }
}
