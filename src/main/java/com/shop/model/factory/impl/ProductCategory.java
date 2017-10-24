package com.shop.model.factory.impl;

public enum ProductCategory {

    BIOGRAPHIES_MEMOIRS("Biographies, memoirs"),
    HISTORY("History"),
    LITERATURE_FICTION("Literature fiction"),
    MYSTERY("Mystery"),
    THRILLER_SUSPENSE("Thriller, suspense"),
    ROMANCE("Romance"),
    SCIENCE_FICTION_FANTASY("Science fiction, fantasy"),
    OTHER("Other");

    private String category;

    ProductCategory(String category) {
        this.category = category;
    }

    public static ProductCategory parseCategory(String category) {
        ProductCategory productCategory = ProductCategory.OTHER;
        if (category != null) {
            productCategory = ProductCategory.valueOf(category);
        }
        return productCategory;
    }
    public String getCategory(){
        return category;
    }
}
