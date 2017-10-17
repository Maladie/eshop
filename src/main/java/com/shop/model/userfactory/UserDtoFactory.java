package com.shop.model.userfactory;

import com.shop.model.UserDto;

import javax.servlet.http.HttpServletRequest;

public interface UserDtoFactory {

    UserDto newUser(HttpServletRequest request);
}
