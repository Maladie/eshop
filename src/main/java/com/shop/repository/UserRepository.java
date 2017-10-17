package com.shop.repository;

import com.shop.model.UserDto;

public interface UserRepository {

    UserDto getUserById(int id);

    void persistUser(UserDto userDto);

    boolean checkIfCredentialsAreCorrect(String login, String password);
}
