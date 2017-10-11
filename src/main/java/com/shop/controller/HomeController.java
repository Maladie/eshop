package com.shop.controller;

import com.shop.model.factory.impl.Product;
import com.shop.repository.impl.ProductRepositoryImpl;
import com.shop.service.ProductService;
import com.shop.service.SessionLastProductViewedHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static com.shop.service.SessionLastProductViewedHandler.retrieveViewedProductList;

@WebServlet(name = "HomeController", value = "/")
public class HomeController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = ProductService.productService(ProductRepositoryImpl.aProductRepository());
        List<Product> productList = productService.getAllProductsForCustomer();
        request.setAttribute("productList", productList);

        List<Product> viewedProductList = SessionLastProductViewedHandler.retrieveViewedProductList(request.getSession()).getViewedProducts();
        request.setAttribute("viewedProductList",viewedProductList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
        requestDispatcher.forward(request, response);
    }
}
