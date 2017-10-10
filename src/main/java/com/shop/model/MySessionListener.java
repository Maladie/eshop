package com.shop.model;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("A new session is created");
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("session is destroyed");
    }
}