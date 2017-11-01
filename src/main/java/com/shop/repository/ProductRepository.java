package com.shop.repository;

import com.shop.model.factory.impl.Product;
import com.shop.model.factory.impl.ProductCategory;

import java.util.List;

public interface ProductRepository {

    List<Product> getAllProducts();

    List<Product> getProductsBySearchCritieria(String searchCriteria);

    List<Product> getProductsByCategory(ProductCategory category);

    Product getProductById(int id);
    Product getProductByISBN13(String ISBN13);
    Product getProductByISBN10(String ISBN10);

    void persistProduct(Product product);

    void deleteProductByID(int id);

    void editProduct(Product updatedProduct);
}
