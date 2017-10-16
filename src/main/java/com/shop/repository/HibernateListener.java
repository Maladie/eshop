package com.shop.repository;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Driver;
import java.util.Enumeration;

public class HibernateListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try
        {   // Load driver class
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (java.lang.ClassNotFoundException e) {
            System.err.println("ClassNotFoundException: " +e);
        }
        HibernateUtils.getEntityManagerFactory();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
      
    }
}
