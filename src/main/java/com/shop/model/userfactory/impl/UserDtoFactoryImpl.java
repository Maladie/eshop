package com.shop.model.userfactory.impl;

import com.shop.model.UserDto;
import com.shop.model.userfactory.UserDtoFactory;

import javax.servlet.http.HttpServletRequest;

public class UserDtoFactoryImpl implements UserDtoFactory {

    @Override
    public UserDto newUser(HttpServletRequest request) {
        UserDto userDto = new UserDto();
        setFieldsFromParameters(userDto, request);
        return userDto;
    }

    private void setFieldsFromParameters(UserDto userDto, HttpServletRequest request){
        userDto.setName(request.getParameter("firstname"));
        userDto.setSurname(request.getParameter("surname"));
        userDto.setUsername(request.getParameter("username"));
        userDto.setPassword(request.getParameter("password"));
        userDto.setAdmin(Boolean.valueOf(request.getParameter("admin")));
    }
}
