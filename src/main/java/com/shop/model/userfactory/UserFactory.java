package com.shop.model.userfactory;

import com.shop.model.userfactory.impl.User;

import javax.servlet.http.HttpServletRequest;

public interface UserFactory {

    User newUser(HttpServletRequest request);
}
