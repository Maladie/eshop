package com.shop.model.userfactory.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private UUID userId;
    private String name;
    private String surname;

    private String username;
    private String password;
    private String salt;

    private boolean admin;


    public User() {
    }

    public int getId() {
        return id;
    }

    public String getSalt() {
        return salt;
    }

    public UUID getUserId() {
        return userId;
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

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
