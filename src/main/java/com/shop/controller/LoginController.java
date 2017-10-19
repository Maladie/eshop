package com.shop.controller;


import com.shop.service.LoginUserService;
import com.shop.service.utils.LoginResult;
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
        String logout = request.getParameter("logout");
        if(logout != null &&logout.equals("true")){
            request.getSession().setAttribute("userName", null);
            request.getRequestDispatcher("logout.jsp").forward(request,response);
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        LoginResult loginResult = LoginUserService.loginService().loginUser(username, password);
        logger.warn("Log attempt: user[" + username + "], password [" + password + "]. Result: "+loginResult);
        if(loginResult.equals(LoginResult.ALL_OK)){
            req.getSession().setAttribute("userName",username);
        } else {
            String message = loginResult.equals(LoginResult.INVALID_LOGIN) ? "Niepoprawny login" : "Niepoprawne hasło";
            req.setAttribute("errorMsg", message);
        }
        res.sendRedirect("/");
    }
}
