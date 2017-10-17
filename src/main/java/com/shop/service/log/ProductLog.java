package com.shop.service.log;

import com.shop.model.factory.impl.Product;
import com.shop.service.Observer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class ProductLog implements Observer{

    private static ProductLog productLog;

    private String fileName = "C:\\Users\\RENT\\IdeaProjects\\eshop\\eshop\\src\\main\\jsp\\log";

    private ProductLog() {
    }

    public static ProductLog getProductLog(){
        if(productLog == null){
            productLog = new ProductLog();
        }
        return productLog;
    }

    @Override
    public void update(String actionDescr, Product product) {
        logProductToFile(actionDescr, product);
    }

    private void logProductToFile(String actionDescr, Product product) {
        List<String> productList =  Arrays.asList(LocalDateTime.now() + " " + actionDescr + " " + product.toString());
        try {
            Files.write(Paths.get(fileName), productList, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
