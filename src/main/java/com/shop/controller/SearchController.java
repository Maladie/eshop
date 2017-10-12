package com.shop.controller;

import com.shop.model.ProductDto;
import com.shop.model.factory.impl.Product;
import com.shop.repository.impl.ProductRepositoryImpl;
import com.shop.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String searchCriteria = httpServletRequest.getParameter("searchParam");
        ProductService productService = ProductService.productService(ProductRepositoryImpl.aProductRepository());
        List<ProductDto> productList = productService.getProductBySearchCriteria(searchCriteria);
        httpServletRequest.setAttribute("productList", productList);
        httpServletRequest.setAttribute("searchParam", searchCriteria);
        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("searchResult.jsp");
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
    }
}
