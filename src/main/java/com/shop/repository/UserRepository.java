package com.shop.repository;

import com.shop.model.UserDto;
import com.shop.model.userfactory.impl.User;

public interface UserRepository {

    void persistUser(UserDto userDto);
    void persistUser(User user);
    boolean checkIfLoginExists(String login);

    User getUserByLogin(String login);
}
