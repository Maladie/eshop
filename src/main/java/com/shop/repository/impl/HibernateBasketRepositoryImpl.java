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
import javax.servlet.http.HttpSession;
import java.util.List;

public class HibernateBasketRepositoryImpl implements BasketRepository {

    private static BasketRepository basketRepository;

    private static EntityManager entityManager;

    private static List<Basket> basketList;

    private HibernateBasketRepositoryImpl(){
        entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        basketList = entityManager.createQuery("SELECT b from Basket b", Basket.class).getResultList();
    }

    public static BasketRepository aBasketRepository(){
        if(basketRepository != null){
            return basketRepository;
        }
        basketRepository = new HibernateBasketRepositoryImpl();
        return basketRepository;
    }

    @Override
    public void submitBasket(String username, Basket basket) {
        basket.setUsername(username);
        entityManager.getTransaction().begin();
        entityManager.persist(basket);
        entityManager.getTransaction().commit();
    }

    public List<Basket> getBasketList() {
        return basketList;
    }

    @Override
    public List<Basket> getBasketListByUsername(String username) {
        return entityManager.createQuery("SELECT b from Basket b WHERE b.username = :username", Basket.class).setParameter("username", username).getResultList();
    }
}
