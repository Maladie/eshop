package com.shop.repository;

import com.shop.model.userfactory.impl.User;
import com.shop.model.UserDto;

public interface UserRepository {

    void persistUser(UserDto userDto);
    void persistUser(User user);
    boolean checkIfLoginExists(String login);
    User getUserById(int id);

    boolean checkIfCredentialsAreCorrect(String login, String password);
    User getUserByLogin(String login);

    boolean isAdmin(String login);
}
