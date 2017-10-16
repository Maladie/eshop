package com.shop.model;

import com.shop.model.userfactory.impl.User;

public class UserToUserDtoTransfomer {

    public static UserDto transformToUser(User user){
        UserDto userDto = new UserDto();
        setUserDtoFields(userDto, user);
        return userDto;
    }

    public static User transformToUser(UserDto userDto){
        User user = new User();
        setUserFields(user, userDto);
        return user;
    }

    private static void setUserFields(User user, UserDto userDto) {
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setPassword(userDto.getPassword());
        user.setAdmin(userDto.isAdmin());
    }

    private static void setUserDtoFields(UserDto userDto, User user){
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setPassword(user.getPassword());
        userDto.setAdmin(user.isAdmin());
    }
}
