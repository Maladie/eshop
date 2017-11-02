package com.shop.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.model.factory.impl.Product;
import com.shop.service.ProductListOperationsService;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// /byISBN/[isbn10]/isbn[13] -->
// one or both:
// /byISBN/1416524797/9781416524793
// Dan Brown "Angels & Demons"

/**
 * /byISBN/[isbn10]/[isbn13] -->
 * one or both:
 * /byISBN/1416524797/9781416524793 Dan Brown "Angels & Demons"
 */
@WebServlet(value = "/byISBN/*")
public class SearchByISBN extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] path = req.getPathInfo().split("/");
        if (path.length > 1) {
            if (path[1].length() == 13 && path[1].chars().allMatch(Character::isDigit)) {
                String isbn = path[1];
                String isbn13= null;
                if(path.length >2) {
                    if(path[2].chars().allMatch(Character::isDigit)) {
                        isbn13 = path[2];
                    } else {
                        System.out.println("Invalid ISBN13: "+ path[2]);
                    }
                }
                Product product = null;
                // search using isbn10
                try { //number length is 10 or 9 if without leading zero
                    if(isbn.length()>8)
                    product = ProductListOperationsService.productService().getProductByISBN10(isbn);
                } catch (NoResultException e) {
                    System.out.println("ISBN10: "+ isbn+ " "+ e.getMessage() + " cause: " + e.getCause());
                }
                //search using isbn13
                if(product == null){
                    try {
                        if(isbn13!=null)
                        product = ProductListOperationsService.productService().getProductByISBN13(isbn13);
                    } catch (NoResultException e) {
                        System.out.println("ISBN13: "+ isbn13+ " "+ e.getMessage() + " cause: " + e.getCause());
                    }
                }
                if(product != null){
                    System.out.println("Found: " + isbn + " " + isbn13);
                    ObjectMapper mapper = new ObjectMapper();
                    String productString = mapper.writeValueAsString(product);
                    resp.setHeader("Content-type", "application/json");
                    resp.getWriter().write(productString);
                } else {
                    resp.setHeader("Content-type", "application/json");
                    resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
                    resp.getWriter().write("Product with ISBN10:"+isbn+ " not found");
                }
            }
        }
    }
}
