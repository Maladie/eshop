package com.shop.model;

import com.shop.model.factory.impl.Product;
import com.shop.model.warehousefactory.impl.Location;
import java.util.Map;

public class WarehouseDto {

    private int id;
    private Location location;
    private Map<Product, Integer> stock;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Map<Product, Integer> getStock() {
        return stock;
    }

    public void setStock(Map<Product, Integer> stock) {
        this.stock = stock;
    }


}
