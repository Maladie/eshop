package com.shop.controller;


import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet{

    final static Logger logger = Logger.getLogger(LoginController.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("login.jsp").forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        logger.warn("Log attemt: user[" + username + "], password [" + password + "]");

        if(username.equals("root") && password.equals("root")){
            System.out.println("root zalogowany");
            req.getSession().setAttribute("userName","root");
            res.sendRedirect("/");
        } else {
            System.out.println("zly login");
            res.sendRedirect("/login");
        }
    }
}
