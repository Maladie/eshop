package com.shop.controller;

import com.shop.model.ProductDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.NoSuchElementException;

import static com.shop.service.ProductService.productService;

@WebServlet(name="Delete", value = "/delete")
public class DeleteProductController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductDto product = productService().getProductById(id);
        request.setAttribute("product", product);
        request.getRequestDispatcher("delete.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            productService().deleteProductById(id);
            response.sendRedirect("/");
        }catch (NoSuchElementException e){
            response.sendRedirect("/");
        }
    }
}
