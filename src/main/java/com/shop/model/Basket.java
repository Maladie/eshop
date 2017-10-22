package com.shop.model;

import com.shop.model.factory.impl.Product;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private LocalDateTime submitDate;
    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL)
    private Set<ProductItem> productItemList;

    public Basket() {
        this.productItemList = new HashSet<>();
    }

    public LocalDateTime getSubmitDate() {
        return submitDate;
    }

    public void addToBasket(Product product){
        Optional<ProductItem> optionalProductItem = productItemList.stream()
                .filter(p -> p.getProduct().getId() == product.getId()).findFirst();
        if(optionalProductItem.isPresent()){
            ProductItem productItem = optionalProductItem.get();
            productItem.incrementQuantify();
        }else{
            ProductItem newProductItem = new ProductItem(product);
            newProductItem.setBasket(this);
            productItemList.add(newProductItem);
        }
    }

    public void removeFromBasket(Product product){
        Optional<ProductItem> optionalProductItem = productItemList.stream()
                .filter(p -> p.getProduct().getId() == product.getId()).findFirst();
        if(optionalProductItem.isPresent()){
            ProductItem productItem = optionalProductItem.get();
            productItemList.remove(productItem);
        }
    }

    public void voidBasket(){
        productItemList.clear();
    }

    public int getBasketSize(){
        return productItemList.size();
    }

    public Integer getProductItemQuantity(int productId){
        Optional<Integer> optionalAmount = productItemList.stream()
                .filter(p -> p.getProduct().getId() == productId).map(ProductItem::getQuantity).findFirst();

            return optionalAmount.orElse(0);
    }

    public Set<ProductItem> productItemList(){
        return productItemList;
    }

    public int getBasketProductItemsAmount() {
        Integer productsAmount = 0;
        for (ProductItem p: productItemList()) {
            productsAmount += p.getQuantity();
        }
        return productsAmount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSubmitDate(LocalDateTime submitDate) {
        this.submitDate = submitDate;
    }
}
