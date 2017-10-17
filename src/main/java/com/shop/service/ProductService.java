package com.shop.service;

import com.shop.model.*;
import com.shop.model.factory.impl.Product;
import com.shop.model.factory.impl.ProductCategory;
import com.shop.repository.ProductRepository;
import com.shop.repository.impl.HibernateRepositoryImpl;
import com.shop.service.log.ProductLog;
import com.shop.service.mail.ProductMailService;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    private List<Observer> observerList;

    private static ProductService productService;

    private ProductRepository productRepository;

    public static ProductService productService() {
        if(productService != null)
            return productService;
        productService = new ProductService(HibernateRepositoryImpl.aProductRepository());
        return productService;
    }

    private ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
        observerList = new ArrayList<>();
        observerList.add(ProductLog.getProductLog());
        observerList.add(ProductMailService.getProductMailService());
    }

    public List<ProductDto> getAllProductsForCustomer() {
        //TODO ?? ok ? quck fix for home controller
        //TODO do obgadania
        return productRepository.getAllProducts().stream().map(product -> ProductToProductDtoConverter.transformToDto(product)).collect(Collectors.toList());
    }

    public List<ProductDto> getProductBySearchCriteria(String searchCriteria) {
        return productRepository.getProductsBySearchCritieria(searchCriteria).stream().map(product -> ProductToProductDtoConverter.transformToDto(product)).collect(Collectors.toList());
    }

    public ProductDto getProductById(int id){
        return ProductToProductDtoConverter.transformToDto(productRepository.getProductById(id));
    }

    public void persistProduct(ProductDto productDto){
        Product product = ProductToProductDtoConverter.transformToProduct(productDto);
        productRepository.persistProduct(product);
    }

    public void addProductToBasket(HttpSession session, int productId){
        Product product = productRepository.getProductById(productId);
        Basket basket = SessionShoppingBasketHandler.retrieveBasket(session);
        basket.addToBasket(product);
    }

    public void removeProductFromBasket(HttpSession session, int productId){
        Basket basket = SessionShoppingBasketHandler.retrieveBasket(session);
        Product product = productRepository.getProductById(productId);
        basket.removeFromBasket(product);
    }

    public void removeAllProductsFromBasket(HttpSession session){
        Basket basket = SessionShoppingBasketHandler.retrieveBasket(session);
        basket.voidBasket();
    }

    public BasketDto getBasketDto(HttpSession session){
        return BasketToBasketDtoConverter.transformToBasketDto(SessionShoppingBasketHandler.retrieveBasket(session));
    }

    public void deleteProductById(int id){
        productRepository.deleteProductByID(id);
    }

    public void editProduct(ProductDto updatedProductDto){
        Product updatedProduct = ProductToProductDtoConverter.transformToProduct(updatedProductDto);
        productRepository.editProduct(updatedProduct);
    }

    public List<ProductDto> filterProductListByPrice(List<ProductDto> productList, String filterCriteria) {
        try {
            BigDecimal maxPrice = BigDecimal.valueOf((Long.parseLong(filterCriteria)));
            productList = productList.stream().filter(product -> product.getValue().compareTo(maxPrice) <= 0).collect(Collectors.toList());
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
        return productList;
    }

    public List<ProductDto> sortProducts(List<ProductDto> filteredList, String sortCriteria) {
        List<ProductDto> sortedList = filteredList;
        switch(sortCriteria){
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

    public List<ProductDto> productListByCategory(String category) {

        ProductCategory productCategory = ProductCategory.valueOf(category.toUpperCase());
        return productRepository.getAllProducts().stream().filter(p -> p.getCategory().equals(productCategory)).map(p -> ProductToProductDtoConverter.transformToDto(p)).collect(Collectors.toList());
    }
}
