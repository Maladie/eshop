package com.shop.service;

import com.shop.model.userfactory.impl.User;
import com.shop.repository.UserRepository;
import com.shop.repository.impl.HibernateUserRepositoryImpl;
import com.shop.service.utils.LoginResult;
import com.shop.service.utils.PasswordUtils;

public class LoginUserService {

    private static LoginUserService userService;

    private UserRepository userRepository;

    public static LoginUserService loginService(){
        if(userService != null){
            return userService;
        }
        userService = new LoginUserService(HibernateUserRepositoryImpl.aUserRepository());
        return userService;
    }

    private LoginUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     *
     * @param login login string
     * @param password password string
     * @return LoginResult -> ALL_OK, INVALID_LOGIN, INVALID_PASSWORD
     */
    public LoginResult loginUser(String login, String password){

        if(!isLoginValid(login)){
            return LoginResult.INVALID_LOGIN;
        } else {
            if(!isPasswordValid(login, password)){
                return LoginResult.INVALID_PASSWORD;
            }
            return LoginResult.ALL_OK;
        }
    }

    boolean isLoginValid(String login){
        if(login != null && !login.equals("")){
            return userRepository.checkIfLoginExists(login);
        }
        return false;
    }
    private boolean isPasswordValid(String login, String password){
        User user = userRepository.getUserByLogin(login);
        String userPassHash = user.getPassword();
        String userPassSalt = user.getSalt();
        return PasswordUtils.verifyPassword(password, userPassHash, userPassSalt);
    }

    public boolean isAdmin(String login){
        if(login != null && !login.equals("")){
            return userRepository.isAdmin(login);
        }
        return false;
    }
}
