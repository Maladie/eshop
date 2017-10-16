package com.shop.model;

import java.util.HashMap;
import java.util.Map;

public class UserDto {

    private int id;

    private String name;
    private String surname;

    private String username;
    private String password;

    private boolean admin;

    private Map<String, Object> parametersMap;

    {
        parametersMap = new HashMap<>();
    }

    public void addToParameters(String paramName, Object object){
        parametersMap.put(paramName, object);
    }

    public Map<String, Object> getParametersMap() {
        return parametersMap;
    }

    public void setParametersMap(Map<String, Object> parametersMap) {
        this.parametersMap = parametersMap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
