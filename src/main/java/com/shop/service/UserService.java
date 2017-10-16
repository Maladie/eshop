package com.shop.service;

import com.shop.repository.UserRepository;
import com.shop.repository.impl.HibernateUserRepositoryImpl;

public class UserService {

    private static UserService userService;

    private UserRepository userRepository;

    public static UserService userService(){
        if(userService != null){
            return userService;
        }
        userService = new UserService(HibernateUserRepositoryImpl.aUserRepository());
        return userService;
    }

    private UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
