package com.shop.controller;

import com.shop.model.ProductDto;
import com.shop.service.ProductListOperationsService;
import com.shop.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryController", value = "/category")
public class CategoryController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category = request.getParameter("category");
        String searchParam = request.getParameter("searchParam");
        ProductListOperationsService productService = ProductListOperationsService.productService();
        List<ProductDto> productList = productService.productListByCategory(category);
        request.setAttribute("productList", productList);
        request.setAttribute("searchParam", searchParam);
        request.setAttribute("category", category);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("searchResult.jsp");
        requestDispatcher.forward(request, response);
    }
}
