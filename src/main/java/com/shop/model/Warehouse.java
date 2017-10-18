package com.shop.model;

import com.shop.model.factory.impl.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class Warehouse {

    private Map<Product, Integer> stock;

    public Warehouse() {
        this.stock = new HashMap<>();
    }

    public void updateStock(Product product, Integer quantity) {
        if(!isInStock(product)) {
            stock.put(product, quantity);
        } else {
            updateProductAmount(product, quantity);
        }
    }

    private boolean isInStock(Product product) {
        Optional<Product> optionalProduct = getOptionalProductById(product.getId());
        if(optionalProduct.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    private void updateProductAmount(Product product, Integer quantity) {
        Product productToUpdate = getOptionalProductById(product.getId()).get();
        Integer actualProductQuantity = stock.get(productToUpdate);
        stock.put(productToUpdate, actualProductQuantity + quantity);
    }

    private Optional<Product> getOptionalProductById(Integer productId) {
        return stock.keySet().stream().filter(p -> p.getId() == productId).findFirst();
    }

}
