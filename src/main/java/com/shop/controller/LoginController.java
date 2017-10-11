package com.shop.controller;


import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet{

    final static Logger logger = Logger.getLogger(LoginController.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println (
                "<html>" +
                "<form action=\"/login\" method=\"post\">" +
                "User name:<br>" +
                "<input type=\"text\" name=\"username\"><br>" +
                "User password:<br>" +
                "<input type=\"password\" name=\"password\"><br>" +
                "<button type=\"submit\" >Login</button>" +
                "</form>" +
                "</html>");
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
