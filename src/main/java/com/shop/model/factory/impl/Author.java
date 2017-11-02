package com.shop.model.factory.impl;

import javax.persistence.*;

@Embeddable
public class Author {

    private String name;
    private String surname;

    public Author(){

    }

    public Author(String authorName, String authorSurname){
        this.name = authorName;
        this.surname = authorSurname;
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
}
