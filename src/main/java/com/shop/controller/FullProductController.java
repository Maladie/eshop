package com.shop.controller;

import com.shop.model.ProductDto;
import com.shop.model.ViewedProductsList;
import com.shop.service.ProductListOperationsService;
import com.shop.service.ProductService;
import com.shop.service.SessionLastProductViewedHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FullProductController", value = "/productDescription")
public class FullProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        Integer id = Integer.parseInt(httpServletRequest.getParameter("product"));
        ProductDto product = ProductListOperationsService.productService().getProductDtoById(id);

        //viewed products log to view
        ViewedProductsList viewedProductsList = SessionLastProductViewedHandler.retrieveViewedProductList(httpServletRequest.getSession());
        if(product !=null) {
            //add to viewed products
            viewedProductsList.addToViewedList(product);
            //set product attribute
            httpServletRequest.setAttribute("product", product);
        } else {
            //remove from viewed list
            viewedProductsList.removeFromViewedList(id);
            //set error attribute
            httpServletRequest.setAttribute("productremovederror","Product not exist");
        }

        httpServletRequest.setAttribute("product", product);
        httpServletRequest.getRequestDispatcher("productDescription.jsp").forward(httpServletRequest, httpServletResponse);
    }
}
