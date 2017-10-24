package com.shop.service;

import com.shop.model.Basket;
import com.shop.model.ProductItem;
import com.shop.model.factory.ProductFactory;
import com.shop.model.factory.impl.Product;
import com.shop.model.factory.impl.ProductFactoryImpl;
import com.shop.repository.ProductRepository;
import com.shop.repository.impl.HibernateProductRepositoryImpl;
import com.shop.service.log.ProductLog;
import com.shop.service.mail.ProductMailService;
import com.shop.service.utils.FtpConnector;
import com.shop.service.utils.WebProsFtpConnector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
        FtpConnector ftpConnector = WebProsFtpConnector.getFtpConnector();
        ftpConnector.uploadFile(request);
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

    public void decreaseQuantityOfSoldProducts(HttpSession session) {
        Basket basket = SessionShoppingBasketHandler.retrieveBasket(session);
        basket.productItemList().stream().forEach(productItem -> {
            Product product = productItem.getProduct();
            int newProductAmount = calculateNewProductAmount(productItem);
            product.setProductAmount(newProductAmount);
            repository.editProduct(product);
        });
    }

    private int calculateNewProductAmount(ProductItem productItem){
        Product product = productItem.getProduct();
        int newProductAmount = product.getProductAmount() - productItem.getQuantity();
        if(newProductAmount < 0){
            newProductAmount = 0;
        }
        return newProductAmount;
    }
}
