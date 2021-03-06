package com.shop.controller;

import com.shop.service.ProductService;
import com.shop.service.utils.FtpConnector;
import com.shop.service.utils.WebProsFtpConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig
@WebServlet(name = "PersistProductController", value = "/persistProduct")
public class PersistProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        boolean isAdmin = (boolean)httpServletRequest.getSession().getAttribute("admin");
        if(isAdmin) {
            httpServletRequest.getRequestDispatcher("addProductForm.jsp").forward(httpServletRequest, httpServletResponse);
        }else {
            System.out.println("Not allowed for non admin users");
            httpServletResponse.sendRedirect("/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        boolean isAdmin = (boolean)request.getSession().getAttribute("admin");
        if(isAdmin) {
            ProductService.productService().persistProduct(request);
        } else {
            System.out.println("Not allowed for non admin users");
        }
        response.sendRedirect("/");
    }
}
