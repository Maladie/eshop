package com.shop.repository;

import com.shop.model.userfactory.impl.User;

public interface UserRepository {

    User getUserById(int id);

    void persistUser(User user);

    User getUserByLoginAndPassword(String login, String password);
}
