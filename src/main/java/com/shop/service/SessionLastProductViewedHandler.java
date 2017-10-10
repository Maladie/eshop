package com.shop.service;

import com.shop.model.ViewedProductsList;

import javax.servlet.http.HttpSession;

public class SessionLastProductViewedHandler {

    public static ViewedProductsList retrieveViewedProductList(HttpSession session){
        if(session.getAttribute("vieweproductslog") != null) {
            session.setAttribute("vieweproductslog", new ViewedProductsList());
        }
        return (ViewedProductsList) session.getAttribute("vieweproductslog");
    }
}
