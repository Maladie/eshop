package com.shop.repository.impl;

import com.shop.model.UserDto;
import com.shop.model.UserToUserDtoTransfomer;
import com.shop.model.userfactory.impl.User;
import com.shop.repository.HibernateUtils;
import com.shop.repository.UserRepository;

import javax.persistence.EntityManager;
import java.util.List;

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

    @Override
    public void persistUser(UserDto userDto) {
        User user = UserToUserDtoTransfomer.transformToUserDto(userDto);
        userList.add(user);
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public boolean checkIfLoginExists(String username) {
        entityManager.getTransaction().begin();
        List<User> result = entityManager.createQuery("Select u from User u where u.username = :username", User.class).setParameter("username", username).getResultList();
        entityManager.getTransaction().commit();
        return result.size() == 1;
    }

    @Override
    public User getUserByLogin(String username) {
        entityManager.getTransaction().begin();
        User user = entityManager.createQuery("select u from User u where u.username = :username", User.class).setParameter("username", username).getSingleResult();
        entityManager.getTransaction().commit();
        return user;
    }

    @Override
    public boolean isAdmin(String login) {
        User user = entityManager.createQuery("select u from User u where LOWER(u.username) = :username", User.class).setParameter("username", login.toLowerCase()).getSingleResult();
        return user != null && user.isAdmin();
    }
}
