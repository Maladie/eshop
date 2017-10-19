package com.shop.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig config)
            throws ServletException {
        // If you have any <init-param> in web.xml, then you could get them
        // here by config.getInitParameter("name") and assign it as field.
    }

    //TODO refactor
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession();

        String requestPath = request.getRequestURI();
        System.out.println(requestPath);

        String loginURL = request.getContextPath() + "/login";

//TODO lock access to register and login page after successfully logged in
        if (doesThisURLNeedsLogin(request.getRequestURI()) && (session.getAttribute("userName") == null)) {
            response.sendRedirect(loginURL);
        } else {
            chain.doFilter(request, response);
        }

    }

    //basic validation of pages that do not require authentication
    private boolean doesThisURLNeedsLogin(String url) {
        String[] URLsThatDoesntRequireLogin = {"/login", "/", "/register"};

        for (String validUrl : URLsThatDoesntRequireLogin) {
            if (url.endsWith(validUrl)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void destroy() {
        // If you have assigned any expensive resources as field of
        // this Filter class, then you could clean/close them here.
    }
}