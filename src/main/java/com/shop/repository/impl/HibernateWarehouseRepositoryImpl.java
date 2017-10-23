package com.shop.repository.impl;


import com.shop.model.factory.impl.Product;
import com.shop.model.warehousefactory.impl.Warehouse;
import com.shop.repository.HibernateUtils;
import com.shop.repository.WarehouseRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

//TODO; implementacja metod interfejsu
public class HibernateWarehouseRepositoryImpl implements WarehouseRepository {

    private static WarehouseRepository warehouseRepository;
    private static EntityManager entityManager;
    private static List<Warehouse> warehouseList;

    private HibernateWarehouseRepositoryImpl() {
        entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        warehouseList = entityManager.createQuery("SELECT w from Warehouse w", Warehouse.class).getResultList();
    }

    public static WarehouseRepository aWarehouseRepository() {
        if (warehouseRepository != null) {
            return warehouseRepository;
        }
        warehouseRepository = new HibernateWarehouseRepositoryImpl();
        return warehouseRepository;
    }

    @Override
    public Warehouse getWarehouseById(int warehouseId) {
        return null;
    }

    @Override
    public void updateProductStock(int warehouseId, Product product, Integer quantity) {

    }

    @Override
    public void addProduct(int warehouseId, Product product, Integer quantity) {

    }

    @Override
    public void persistWarehouse(Warehouse warehouse) {

    }

    @Override
    public void deleteWarehouseById(int warehouseId) {

    }

    @Override
    public Integer getSingleProductStock(int warehouseId, int productId) {
        return null;
    }
}