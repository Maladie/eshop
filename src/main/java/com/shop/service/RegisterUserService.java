package com.shop.service;

import com.shop.model.userfactory.UserFactory;
import com.shop.model.userfactory.impl.User;
import com.shop.model.userfactory.impl.UserFactoryImpl;
import com.shop.repository.UserRepository;
import com.shop.repository.impl.HibernateUserRepositoryImpl;
import com.shop.service.utils.PasswordUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

public class RegisterUserService {

    private static RegisterUserService userService;

    private UserRepository userRepository;

    public static RegisterUserService userService(){
        if(userService != null){
            return userService;
        }
        userService = new RegisterUserService(HibernateUserRepositoryImpl.aUserRepository());
        return userService;
    }

    private RegisterUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isLoginAvailable(String login){
        return !LoginUserService.loginService().isLoginValid(login);
    }

    public void registerUser(HttpServletRequest request){
        UserFactory userFactory = new UserFactoryImpl();
        User user = userFactory.newUser(request);
        boolean validUsername = isLoginAvailable(user.getUsername());
        if(validUsername) {
            userRepository.persistUser(user);
            System.out.println("=========================================================");
            System.out.println(" Registered as {"+user.getUsername()+"}");
            System.out.println("=========================================================");
        } else {
            System.out.println("=========================================================");
            System.out.println(" User login ("+user.getUsername()+") already used!!! ");
            System.out.println("=========================================================");
        }
    }
}
