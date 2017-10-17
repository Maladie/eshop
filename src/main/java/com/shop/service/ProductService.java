package com.shop.service;

import com.shop.model.*;
import com.shop.model.factory.impl.Product;
import com.shop.model.factory.impl.ProductCategory;
import com.shop.repository.ProductRepository;
import com.shop.repository.impl.HibernateProductRepositoryImpl;
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

    public List<ProductDto> getAllProductsForCustomer() {
        //TODO ?? ok ? quck fix for home controller
        //TODO do obgadania
        return repository.getAllProducts().stream().map(product -> ProductToProductDtoTransformer.transformToDto(product)).collect(Collectors.toList());
    }

    public List<ProductDto> getProductBySearchCriteria(String searchCriteria) {
        return repository.getProductsBySearchCritieria(searchCriteria).stream().map(product -> ProductToProductDtoTransformer.transformToDto(product)).collect(Collectors.toList());
    }

    public ProductDto getProductById(int id) {
        Product product = repository.getProductById(id);
        if (product == null) {
            return null;
        }
        return ProductToProductDtoTransformer.transformToDto(repository.getProductById(id));
    }

    public void persistProduct(ProductDto productDto) {
        Product product = ProductToProductDtoTransformer.transformToProduct(productDto);
        repository.persistProduct(product);
    }

    public void addProductToBasket(HttpSession session, int productId) {
        Product product = repository.getProductById(productId);
        Basket basket = SessionShoppingBasketHandler.retrieveBasket(session);
        basket.addToBasket(product);
    }

    public void removeProductFromBasket(HttpSession session, int productId) {
        Basket basket = SessionShoppingBasketHandler.retrieveBasket(session);
        Product product = repository.getProductById(productId);
        basket.removeFromBasket(product);
    }

    public void removeAllProductsFromBasket(HttpSession session) {
        Basket basket = SessionShoppingBasketHandler.retrieveBasket(session);
        basket.voidBasket();
    }

    public BasketDto getBasketDto(HttpSession session){
        return BasketToBasketDtoTransformer.transformToBasketDto(SessionShoppingBasketHandler.retrieveBasket(session));
    }

    public void deleteProductById(int id) {
        repository.deleteProductByID(id);
    }

    public void editProduct(ProductDto updatedProductDto){
        Product updatedProduct = ProductToProductDtoTransformer.transformToProduct(updatedProductDto);
        repository.editProduct(updatedProduct);
    }

    public List<ProductDto> filterProductListByPrice(List<ProductDto> productList, String filterCriteria) {
        try {
            if (filterCriteria.equals("")) {
                //TODO temp fix if filter has no value
                filterCriteria = BigDecimal.valueOf(Long.MAX_VALUE).toString();
            }
            BigDecimal maxPrice = new BigDecimal(filterCriteria);
            productList = productList.stream().filter(product -> product.getValue().compareTo(maxPrice) <= 0).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public List<ProductDto> sortProducts(List<ProductDto> filteredList, String sortCriteria) {
        List<ProductDto> sortedList = filteredList;
        switch (sortCriteria) {
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
            default:
                return sortedList;
        }
    }

    public List<ProductDto> filterProductsByCategory(List<ProductDto> productDtoList, String category) {
        if(!category.equals("")){
            productDtoList.removeIf(productDto -> productDto.getParametersMap().get("category") != ProductCategory.valueOf(category));
        }
        return productDtoList;
    }

    public List<ProductDto> productListByCategory(String category) {

        ProductCategory productCategory = ProductCategory.valueOf(category.toUpperCase());
        return repository.getAllProducts().stream().filter(p -> p.getCategory().equals(productCategory)).map(p -> ProductToProductDtoTransformer.transformToDto(p)).collect(Collectors.toList());
    }
}
