package com.shop.service;

import com.shop.model.userfactory.impl.User;
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
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setUsername(userName);
        user.setUserId(UUID.randomUUID());
        setUserPassword(user, password);
        userRepository.persistUser(user);
    }

    private void setUserPassword(User user, String pass){
        String salt = generateSalt();
        user.setSalt(salt);
        String password = PasswordUtils.generatePasswordHash(pass, salt);
        user.setPassword(password);
    }

    private String generateSalt(){
        return PasswordUtils.generateSalt();
    }
}
