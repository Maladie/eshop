package com.shop.repository.impl;

import com.shop.model.factory.ProductFactory;
import com.shop.model.factory.impl.Product;
import com.shop.model.factory.impl.ProductFactoryImpl;
import com.shop.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductRepositoryImpl implements ProductRepository {

    private static ProductRepository productRepository;

    private static String FULL_DESCRIPTION = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque sit amet sapien vehicula, convallis nisl in, vehicula eros. Nam hendrerit rhoncus ultricies. Mauris pellentesque, dui at fringilla placerat, enim turpis sagittis leo, mollis facilisis libero nisi non massa. Praesent facilisis ut ex at porta. Nunc ac est sit amet risus maximus pulvinar. Vivamus at nunc elementum, elementum tellus vel, faucibus neque. Sed elementum eget tellus in dapibus. Pellentesque condimentum maximus elit ac elementum. Vivamus quis luctus leo, non gravida eros. Nunc mauris tellus, egestas ut commodo eu, iaculis id arcu. Donec ultricies mi id eros pulvinar viverra. Cras non nibh purus. Ut sit amet ipsum massa. Vivamus porttitor ac ex ut condimentum. Nulla condimentum et magna ut dapibus.";

    public static ProductRepository aProductRepository() {
        if(productRepository != null) {
            return productRepository;
        }
        productRepository = new ProductRepositoryImpl();
        return productRepository;
    }

    private ProductRepositoryImpl() {}

    private static List<Product> mockProductList = new ArrayList<>();


    public List<Product> getAllProducts() {
        if(mockProductList.size() == 0) {
            initMockRepo();
        }
        return mockProductList;
    }

    public Product getProductById(int id) {
         return mockProductList.stream().filter(p -> p.getId() == id).findFirst().get();
    }

    public void persistProduct(Product product){
        mockProductList.add(product);
    }

    public void deleteProductByID(int id){
        mockProductList.remove(getProductById(id));
    }

    public void editProduct(Product updatedProduct) {
        Product product = getProductById(updatedProduct.getId());
        product.setName(updatedProduct.getName());
        BigDecimal value = product.getValue();
        BigDecimal newValue = updatedProduct.getValue();
        if(newValue != null){
            value = newValue;
        }
        product.setValue(value);
        product.setCurrency(updatedProduct.getCurrency());
    }

    public List<Product> getProductsBySearchCritieria(String searchCriteria){
        return mockProductList.stream().filter(p -> p.getName().toLowerCase().contains(searchCriteria.toLowerCase()))
                .collect(Collectors.toList());
    }

    private void initMockRepo() {
        ProductFactory productFactory = new ProductFactoryImpl();
        for(int i = 0 ;i <20; i ++) {
            Product product = productFactory.newProduct("Product number " + i,new BigDecimal(5+i*2),"PLN", FULL_DESCRIPTION);
            product.setProductAmount(0);
            mockProductList.add(product);
        }
        for(int i = 0 ;i <10; i ++) {
            Product product = productFactory.newProduct("Gitara basowa " + i,new BigDecimal(5+i*2),"PLN", FULL_DESCRIPTION);
            mockProductList.add(product);
        }
        for(int i = 0 ;i <10; i ++) {
            Product product = productFactory.newProduct("Gitara zwykla " + i,new BigDecimal(5+i*2),"PLN", FULL_DESCRIPTION);
            mockProductList.add(product);
        }
    }

}
