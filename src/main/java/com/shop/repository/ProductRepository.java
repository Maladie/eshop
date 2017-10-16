package com.shop.repository;

import com.shop.model.productfactory.impl.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getAllProducts();

    List<Product> getProductsBySearchCritieria(String searchCriteria);

    Product getProductById(int id);

    void persistProduct(Product product);

    void deleteProductByID(int id);

    void editProduct(Product updatedProduct);
}
