package com.shop.model;

import java.util.ArrayList;
import java.util.List;

public class SubmittedBasketsList {

    private static SubmittedBasketsList instance;
    private List<BasketDto> submittedBaskets;

    private SubmittedBasketsList() {
        submittedBaskets = new ArrayList<>();
    }

    public static SubmittedBasketsList getInstance() {
        if(instance == null) {
            instance = new SubmittedBasketsList();
        }
        return instance;
    }

    public void addToSubmittedBaskets(BasketDto basket){
        submittedBaskets.add(basket);
    }

    public List<BasketDto> getSubmittedBaskets() {
        return submittedBaskets;
    }
}
