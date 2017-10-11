package com.shop.service;

import com.shop.model.Basket;
import com.shop.model.BasketDto;
import com.shop.model.BasketToBasketDtoConverter;
import com.shop.model.factory.impl.Product;
import com.shop.repository.ProductRepository;
import com.shop.service.log.ProductLog;
import com.shop.service.mail.ProductMailService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    private List<Observer> observerList;

    private static ProductService productService;

    private ProductRepository repository;

    public static ProductService productService(ProductRepository productRepository) {
        if(productService != null)
            return productService;
        productService = new ProductService(productRepository);
        return productService;
    }

    private ProductService(ProductRepository productRepository) {
        this.repository = productRepository;
        observerList = new ArrayList<>();
        observerList.add(ProductLog.getProductLog());
        observerList.add(ProductMailService.getProductMailService());
    }

    public List<Product> getAllProductsForCustomer() {
        return repository.getAllProducts();
    }

    public List<Product> getProductBySearchCriteria(String searchCriteria) {
        return repository.getProductsBySearchCritieria(searchCriteria);
    }

    public Product getProductById(int id){
        return repository.getProductById(id);
    }

    public void persistProduct(Product product){
        repository.persistProduct(product);
        notifyObservers("Created new", product);
    }

    private void notifyObservers(String actionDescription, Product product) {
        observerList.stream().forEach(observer -> observer.update(actionDescription, product));
    }

    public void addProductToBasket(BasketDto basketDto, int productId){
        Product product = repository.getProductById(productId);
        Basket basket = BasketToBasketDtoConverter.convertToBasket(basketDto);
        basket.addToBasket(product);
    }

    public void deleteProductById(int id){
        repository.deleteProductByID(id);
    }

    public void editProduct(Product updatedProduct){
        repository.editProduct(updatedProduct);
    }

    public List<Product> filterProductListByPrice(List<Product> productList, String filterCritieria) {
        try {
            BigDecimal maxPrice = BigDecimal.valueOf((Long.parseLong(filterCritieria)));
            productList = productList.stream().filter(product -> product.getValue().compareTo(maxPrice) <= 0).collect(Collectors.toList());
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
        return productList;
    }

    public List<Product> sortProducts(List<Product> filteredList, String sortCritiera) {
        List<Product> sortedList = filteredList;
        switch(sortCritiera){
            case "plh":
                sortedList = sortedList.stream().sorted((o1, o2) -> o1.getValue().compareTo(o2.getValue())).collect(Collectors.toList());
                return sortedList;
            case "phl":
                sortedList = sortedList.stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())).collect(Collectors.toList());
                return sortedList;
            case "alp":
                sortedList = sortedList.stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
                return sortedList;
            case "id":
                sortedList = sortedList.stream().sorted((o1, o2) -> o2.getId() - o1.getId()).collect(Collectors.toList());
                return sortedList;
            default: return sortedList;
        }
    }
}
