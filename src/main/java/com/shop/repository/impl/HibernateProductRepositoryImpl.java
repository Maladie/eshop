package com.shop.repository.impl;

import com.shop.model.factory.impl.Product;
import com.shop.model.factory.impl.ProductCategory;
import com.shop.repository.HibernateUtils;
import com.shop.repository.ProductRepository;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class HibernateProductRepositoryImpl implements ProductRepository {
    private static ProductRepository productRepository;
    private static EntityManager entityManager;

    private static List<Product> productList;

    private HibernateProductRepositoryImpl(){
        entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        productList = entityManager.createQuery("SELECT p from Product p", Product.class).getResultList();
    }

    public static ProductRepository aProductRepository(){
        if(productRepository != null){
            return productRepository;
        }
        productRepository = new HibernateProductRepositoryImpl();
        return productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productList;
    }

    @Override
    public List<Product> getProductsBySearchCritieria(String searchCriteria) {
        return entityManager.createQuery("SELECT p from Product p WHERE p.title LIKE :search", Product.class).setParameter("search", searchCriteria +"%").getResultList();
    }

    @Override
    public List<Product> getProductsByCategory(ProductCategory category) {
        return entityManager.createQuery("select p from Product p where p.category = :cat", Product.class).setParameter("cat", category).getResultList();
    }

    @Override
    public Product getProductById(int id) {
        return productList.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Product getProductByISBN13(String ISBN13) {
        return entityManager.createQuery("select p from Product p WHERE p.ISBN13 = :isbn", Product.class).setParameter("isbn", ISBN13).getSingleResult();
    }

    @Override
    public Product getProductByISBN10(String ISBN10) {
        return entityManager.createQuery("select p from Product p where p.ISBN10 = :isbn", Product.class).setParameter("isbn", ISBN10).getSingleResult();
    }

    @Override
    public void persistProduct(Product product) {
        productList.add(product);
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteProductByID(int id) {
        Product product = getProductById(id);
        productList.remove(product);
        if(product != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(product);
            entityManager.getTransaction().commit();
        }
        productList.remove(product);
    }

    @Override
    public void editProduct(Product updatedProduct) {
        Product product = getProductById(updatedProduct.getId());
        product.setTitle(updatedProduct.getTitle());
        product.setDescription(updatedProduct.getDescription());
        //skip if lower than 0
        product.setProductAmount(updatedProduct.getProductAmount()>=0 ?updatedProduct.getProductAmount(): product.getProductAmount());
        product.setISBN10(updatedProduct.getISBN10());
        product.setISBN13(updatedProduct.getISBN13());
        product.setAuthor(updatedProduct.getAuthor());
        product.setCategory(updatedProduct.getCategory());
        BigDecimal value = product.getValue();
        BigDecimal newValue = updatedProduct.getValue();
        if(newValue != null){
            value = newValue;
        }
        product.setValue(value);
        product.setCurrency(updatedProduct.getCurrency());
        entityManager.getTransaction().begin();
        entityManager.merge(product);
        entityManager.getTransaction().commit();
    }
}
