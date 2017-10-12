package com.shop.repository;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Driver;
import java.util.Enumeration;

public class HibernateListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        HibernateUtils.getEntityManagerFactory();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        HibernateUtils.shutdown();
        //BUG-FIX Warning - JDBC driver unregister failed on server shutdown
        Enumeration<Driver> drivers = java.sql.DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            java.sql.Driver driver = drivers.nextElement();
            try {
                java.sql.DriverManager.deregisterDriver(driver);
            } catch (Throwable t) {
                System.out.println(t.getMessage());
            }
        }
    }
}
