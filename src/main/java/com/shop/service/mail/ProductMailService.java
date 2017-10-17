package com.shop.service.mail;

import com.shop.model.factory.impl.Product;
import com.shop.service.Observer;

public class ProductMailService implements Observer {

    public static ProductMailService productMailService;

    private ProductMailService() {
    }

    public static ProductMailService getProductMailService(){
        if(productMailService != null){
            return productMailService;
        }
        productMailService = new ProductMailService();
        return productMailService;
    }

    @Override
    public void update(String actionDescr, Product product) {
        System.out.println(actionDescr + " " +product);
    }
}
