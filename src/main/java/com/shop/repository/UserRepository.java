package com.shop.repository;

import com.shop.model.UserDto;

public interface UserRepository {

    UserDto getUserById(int id);

    void persistUser(UserDto userDto);

    UserDto getUserByLoginAndPassword(String login, String password);
}
