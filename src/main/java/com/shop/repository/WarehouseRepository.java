package com.shop.repository;

import com.shop.model.factory.impl.Product;
import com.shop.model.warehousefactory.impl.Warehouse;

public interface WarehouseRepository {

    Warehouse getWarehouseById(int warehouseId);
    void updateProductStock(int warehouseId, Product product, Integer quantity);
    void addProduct(int warehouseId, Product product, Integer quantity);
    void persistWarehouse(Warehouse warehouse);
    void deleteWarehouseById(int warehouseId);
    Integer getSingleProductStock(int warehouseId, int productId);
}
