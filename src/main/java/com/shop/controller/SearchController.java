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

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.setCharacterEncoding("UTF-8");
        String searchCriteria = httpServletRequest.getParameter("searchParam");
        ProductListOperationsService productService = ProductListOperationsService.productService();
        List<ProductDto> productList = productService.getProductBySearchCriteria(searchCriteria);
        httpServletRequest.setAttribute("productList", productList);
        httpServletRequest.setAttribute("searchParam", searchCriteria);
        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("searchResult.jsp");
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
    }
}
