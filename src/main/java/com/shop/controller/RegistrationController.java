package com.shop.controller;

import com.shop.service.RegisterUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "Registration", value = "/register")
public class RegistrationController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String validateUserName = request.getParameter("validateUserName");
        if(validateUserName != null){
            boolean result= RegisterUserService.userService().isLoginAvailable(validateUserName);
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(result? "available" : "unavailable");
        } else {
            RegisterUserService.userService().registerUser(request);
            response.sendRedirect("/home");
        }
    }
}
