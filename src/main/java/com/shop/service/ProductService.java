package com.shop.service;

import com.shop.model.factory.ProductFactory;
import com.shop.model.factory.impl.Product;
import com.shop.model.factory.impl.ProductFactoryImpl;
import com.shop.repository.ProductRepository;
import com.shop.repository.impl.HibernateProductRepositoryImpl;
import com.shop.service.log.ProductLog;
import com.shop.service.mail.ProductMailService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private List<Observer> observerList;

    private static ProductService productService;

    private ProductRepository repository;

    public static ProductService productService() {
        if(productService != null)
            return productService;
        productService = new ProductService(HibernateProductRepositoryImpl.aProductRepository());
        return productService;
    }

    private ProductService(ProductRepository productRepository) {
        this.repository = productRepository;
        observerList = new ArrayList<>();
        observerList.add(ProductLog.getProductLog());
        observerList.add(ProductMailService.getProductMailService());
    }

    public void persistProduct(HttpServletRequest request) {
        ProductFactory productFactory = new ProductFactoryImpl();
        Product product = productFactory.newProduct(request);
        repository.persistProduct(product);
    }

    public void deleteProductById(int id) {
        repository.deleteProductByID(id);
    }

    public void editProduct(HttpServletRequest request){
        ProductFactory productFactory = new ProductFactoryImpl();
        Product updatedProduct = productFactory.getProductUpdateTemplate(request);
        repository.editProduct(updatedProduct);
    }
}
