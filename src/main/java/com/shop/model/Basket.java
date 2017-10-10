package com.shop.model;

import com.shop.model.factory.impl.Product;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Basket {

    private Set<ProductItem> productItemList;

    public Basket() {
        this.productItemList = new HashSet<>();
    }

    public void addToBasket(Product product){
        Optional<ProductItem> optionalProductItem = productItemList.stream()
                .filter(p -> p.getProduct().getId() == product.getId()).findFirst();
        if(optionalProductItem.isPresent()){
            ProductItem productItem = optionalProductItem.get();
            productItem.incrementQuantify();
        }else{
            ProductItem newProductItem = new ProductItem(product);
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

    public int getBasketSize(){
        return productItemList.size();
    }

    public Integer getProductItemQuantity(int productId){
        Optional<Integer> optionalAmount = productItemList.stream()
                .filter(p -> p.getProduct().getId() == productId).map(p -> p.getQuantity()).findFirst();

            return optionalAmount.isPresent() ? optionalAmount.get() : 0;
    }

    Set<ProductItem> productItemList(){
        return productItemList;
    }

}
