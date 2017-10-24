package com.shop.model.userfactory.impl;

import com.shop.model.userfactory.UserFactory;
import com.shop.service.utils.PasswordUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

public class UserFactoryImpl implements UserFactory {

    @Override
    public User newUser(HttpServletRequest request) {
        User user = new User();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        user.setName(name);
        user.setSurname(surname);
        user.setUsername(userName);
        user.setUserId(UUID.randomUUID());
        setUserPassword(user, password);
        return user;
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
