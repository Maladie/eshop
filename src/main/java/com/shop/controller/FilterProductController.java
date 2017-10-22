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

@WebServlet(name = "Filter", value = "/filter")
public class FilterProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String searchParam = request.getParameter("searchParam");
        String category = request.getParameter("category");
        String filterCriteria = request.getParameter("filterParam");
        String sortCriteria = request.getParameter("sortType");

        List<ProductDto> productList = ProductListOperationsService.productService().getProductBySearchCriteria(searchParam);
        //filter products with category value if set to any
        productList =  ProductListOperationsService.productService().filterProductsByCategory(productList, category);
        List<ProductDto> filteredList = ProductListOperationsService.productService().filterProductListByPrice(productList, filterCriteria);
        if(sortCriteria != null){
            filteredList = ProductListOperationsService.productService().sortProducts(filteredList, sortCriteria);
        }
        request.setAttribute("searchParam", searchParam);
        request.setAttribute("productList", filteredList);
        request.setAttribute("category", category);
        request.setAttribute("filterParam", filterCriteria);
        request.setAttribute("sortType", sortCriteria);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("searchResult.jsp");
        requestDispatcher.forward(request, response);
    }
}
