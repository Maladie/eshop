package com.shop.service;

import com.shop.model.UserDto;
import com.shop.model.userfactory.UserDtoFactory;
import com.shop.model.userfactory.impl.UserDtoFactoryImpl;
import com.shop.repository.UserRepository;
import com.shop.repository.impl.HibernateProductRepositoryImpl;
import com.shop.repository.impl.HibernateUserRepositoryImpl;

import javax.servlet.http.HttpServletRequest;

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

    public void registerNewUser(HttpServletRequest request){
        UserDtoFactory userDtoFactory = new UserDtoFactoryImpl();
        UserDto userDto = userDtoFactory.newUser(request);
        HibernateUserRepositoryImpl.aUserRepository().persistUser(userDto);
    }
}