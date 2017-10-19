package com.shop.model;

import com.shop.model.factory.impl.Product;
import com.shop.model.userfactory.impl.User;
import org.apache.commons.lang3.mutable.MutableInt;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

public class Basket {

    private int id;

    private int userId;

    private Set<Map<Product, MutableInt>> productItemList;

    public Basket() {
        this.productItemList = new HashSet<>();
    }

    public void addToBasket(Product product){
        Optional<Map<Product, MutableInt>> optionalProductItem = productItemList.stream()
                .filter(p -> p.containsKey(product)).findFirst();
        if(optionalProductItem.isPresent()){
            Map<Product, MutableInt> productItem = optionalProductItem.get();
            MutableInt value = productItem.get(product);
            value.increment();
        }else{
            Map<Product, MutableInt> productItem = new HashMap<>();
            productItem.put(product, new MutableInt(1));
            productItemList.add(productItem);
        }
    }

    public void removeFromBasket(Product product){
        Optional<Map<Product, MutableInt>> optionalProductItem = productItemList.stream()
                .filter(p -> p.containsKey(product)).findFirst();
        if(optionalProductItem.isPresent()){
            Map<Product, MutableInt> productItem = optionalProductItem.get();
            productItemList.remove(productItem);
        }
    }

    public void voidBasket(){
        productItemList.clear();
    }

    public int getBasketSize(){
        return productItemList.size();
    }

//    public Integer getProductItemQuantity(int productId){
//        Optional<Integer> optionalAmount = productItemList.stream()
//                .filter(p -> p.getProduct().getId() == productId).map(ProductItem::getQuantity).findFirst();
//
//            return optionalAmount.orElse(0);
//    }

    Set<Map<Product, MutableInt>> productItemList(){
        return productItemList;
    }

    public int getBasketProductItemsAmount() {
        Integer productsAmount = 0;
        for (Map<Product, MutableInt> p: productItemList()) {
            Product product = (Product) p.keySet().toArray()[0];
            productsAmount += p.get(product).getValue();
        }
        return productsAmount;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public static BigDecimal value(Map<Product, MutableInt> productMutableIntMap){
        Product product = (Product) productMutableIntMap.keySet().toArray()[0];
        int quantity = productMutableIntMap.get(product).getValue();
        BigDecimal bigDecimalQuantity = BigDecimal.valueOf(quantity);
        return product.getValue().multiply(bigDecimalQuantity);
    }
}
