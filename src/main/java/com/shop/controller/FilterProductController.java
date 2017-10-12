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

@WebServlet(name = "Filter", value = "/filter")
public class FilterProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchCriteria = request.getParameter("searchParam");
        String filterCriteria = request.getParameter("filterParam");
        String sortCriteria = request.getParameter("sortType");
        List<ProductDto> productList = ProductService.productService().getProductBySearchCriteria(searchCriteria);
        List<ProductDto> filteredList = ProductService.productService().filterProductListByPrice(productList, filterCriteria);
        if(sortCriteria != null){
            filteredList = ProductService.productService().sortProducts(filteredList, sortCriteria);
        }
        request.setAttribute("productList", filteredList);
        request.setAttribute("searchParam", searchCriteria);
        request.setAttribute("filterParam", filterCriteria);
        request.setAttribute("sortType", sortCriteria);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("searchResult.jsp");
        requestDispatcher.forward(request, response);
    }
}
