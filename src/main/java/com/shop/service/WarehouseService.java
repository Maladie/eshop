package com.shop.service;

import com.shop.model.factory.impl.Product;
import com.shop.repository.WarehouseRepository;
import com.shop.repository.impl.HibernateWarehouseRepositoryImpl;

import java.util.Optional;

public class WarehouseService {

    private static WarehouseService warehouseService;

    private WarehouseRepository warehouseRepository;

    public static WarehouseService warehouseService() {
        if (warehouseService != null) {
            return warehouseService;
        }
        warehouseService = new WarehouseService(HibernateWarehouseRepositoryImpl.aWarehouseRepository());
        return warehouseService;
    }

    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    public void updateStock(int warehouseId, Product product, Integer quantity) {
            if (quantity > 0 && !isInStock(warehouseId, product)) {
                warehouseRepository.addProduct(warehouseId, product, quantity);
            } else  if(quantity != 0){
                updateProductAmount(warehouseId, product, quantity);
            }
    }

    private boolean isInStock(int warehouseId, Product product) {
        Optional<Product> optionalProduct = getOptionalProductById(warehouseId, product.getId());
        if (optionalProduct.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    private void updateProductAmount(int warehouseId, Product product, Integer quantity) {
        Integer actualProductQuantity = warehouseRepository.getSingleProductStock(warehouseId, product.getId());
        warehouseRepository.updateProductStock(warehouseId, product, actualProductQuantity + quantity);
    }

    private Optional<Product> getOptionalProductById(int warehouseId, int productId) {
        return warehouseRepository.getWarehouseById(warehouseId).getStock().keySet().stream().filter(p -> p.getId() == productId).findFirst();
    }

    public Integer getSingleProductStock(int warehouseId, int productId) {
       return warehouseRepository.getSingleProductStock(warehouseId, productId);
    }
}
