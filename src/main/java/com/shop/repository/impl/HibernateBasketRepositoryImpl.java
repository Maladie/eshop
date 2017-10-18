package com.shop.repository.impl;

import com.shop.model.Basket;
import com.shop.model.BasketDto;
import com.shop.model.BasketToBasketDtoTransformer;
import com.shop.model.UserDto;
import com.shop.model.factory.impl.Product;
import com.shop.model.userfactory.impl.User;
import com.shop.repository.BasketRepository;
import com.shop.repository.HibernateUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class HibernateBasketRepositoryImpl implements BasketRepository {

    private static BasketRepository basketRepository;

    private static EntityManager entityManager;

    private static List<Basket> basketList;

    private HibernateBasketRepositoryImpl(){
        entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
//        basketList = entityManager.createQuery("SELECT b from Basket b", Basket.class).getResultList(); //Tymczasowo wyłączone, encja nie istnieje w bazie
    }

    public static BasketRepository aBasketRepository(){
        if(basketRepository != null){
            return basketRepository;
        }
        basketRepository = new HibernateBasketRepositoryImpl();
        return basketRepository;
    }

    @Override
    public void submitBasket(int userId, Basket basket) {
        basket.setUserId(userId);
        entityManager.getTransaction().begin();
        entityManager.persist(basket);
        entityManager.getTransaction().commit();
    }
}
