package com.shop.model;

import java.util.ArrayList;
import java.util.List;

public class SubmittedBasketsList {

    private List<BasketDto> submittedBaskets;

    private SubmittedBasketsList() {
        submittedBaskets = new ArrayList<>();
    }

    public void addToSubmittedBaskets(BasketDto basket){
        submittedBaskets.add(basket);
    }

    public List<BasketDto> getSubmittedBaskets() {
        return submittedBaskets;
    }
}
