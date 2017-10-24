package com.shop.model;

import com.shop.model.userfactory.impl.User;

public class UserToUserDtoTransfomer {

    public static User transformToUserDto(UserDto userDto){
        User user = new User();
        setUserFields(user, userDto);
        return user;
    }

    private static void setUserFields(User user, UserDto userDto) {
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setAdmin(userDto.isAdmin());
    }

}
