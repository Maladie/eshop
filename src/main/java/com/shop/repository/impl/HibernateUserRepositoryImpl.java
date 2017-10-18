package com.shop.repository.impl;

import com.shop.model.UserDto;
import com.shop.model.UserToUserDtoTransfomer;
import com.shop.model.userfactory.impl.User;
import com.shop.repository.HibernateUtils;
import com.shop.repository.UserRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.NoSuchElementException;

public class HibernateUserRepositoryImpl implements UserRepository {
    private static UserRepository userRepository;
    private static EntityManager entityManager;
    private static List<User> userList;

    private HibernateUserRepositoryImpl(){
        entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        userList = entityManager.createQuery("SELECT u from User u", User.class).getResultList();
    }

    public static UserRepository aUserRepository(){
        if(userRepository != null){
            return userRepository;
        }
        userRepository = new HibernateUserRepositoryImpl();
        return userRepository;
    }


    @Override
    public User getUserById(int id) {
        return entityManager.createQuery("SELECT u from User u WHERE u.id = :id", User.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public void persistUser(User user) {
        userList.add(user);
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public boolean checkIfCredentialsAreCorrect(String login, String password) {
        List<User> userList = entityManager.createQuery("SELECT u from User u WHERE u.username = :login AND u.password = :password", User.class)
                .setParameter("login", login).setParameter("password", password).getResultList();
        return !userList.isEmpty();
    }
}
