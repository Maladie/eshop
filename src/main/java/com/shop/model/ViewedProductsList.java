package com.shop.model;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ViewedProductsList {
    private List<ProductDto> productsList;
    private final int maxStoredProducts = 3;
    private final static Logger logger = Logger.getLogger(ViewedProductsList.class);

    public ViewedProductsList() {
        productsList = new ArrayList<>();
    }


    public void addToViewedList(ProductDto product) {
        List<Integer> idList = productsList.stream().map(productDto -> productDto.getId()).collect(Collectors.toList());
        if (!idList.contains(product.getId())) {
            productsList.add(0, product);
            if (productsList.size() > maxStoredProducts) {
                productsList.remove(maxStoredProducts - 1);
            }
        } else {
            int id = product.getId();
            ProductDto productDto = productsList.stream().filter(productDto1 -> productDto1.getId() == id).findFirst().get();
            productsList.remove(productDto);
            //TODO do przerobienia
            addToViewedList(product);
        }
    }

    public List<ProductDto> getViewedProducts() {
        return productsList;
    }

    public void removeFromViewedList(Integer id) {
        boolean removed = productsList.removeIf(productDto -> productDto.getId() == id);
        logger.debug("Product with id=" + id + " remove attempt " + (removed ? "success" : "failed - not found in list"));
    }
}
