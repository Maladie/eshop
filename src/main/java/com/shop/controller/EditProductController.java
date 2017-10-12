package com.shop.controller;

import com.shop.model.ProductDto;
import com.shop.model.factory.ProductFactory;
import com.shop.model.factory.impl.Product;
import com.shop.model.factory.impl.ProductFactoryImpl;
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
        ProductDto product = getProductById(request);
        request.setAttribute("product", product);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductFactory productFactory = new ProductFactoryImpl();
        Product updatedProduct = productFactory.getProductUpdateTemplate(request);
        ProductService.productService(ProductRepositoryImpl.aProductRepository()).editProduct(updatedProduct);
        response.sendRedirect("/");
    }

    private ProductDto getProductById(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        return ProductService.productService(ProductRepositoryImpl.aProductRepository()).getProductById(id);
    }
}
