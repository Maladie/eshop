package com.shop.model.factory.impl;

import com.shop.model.factory.ProductFactory;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

public class ProductFactoryImpl implements ProductFactory {

    @Override
    public Product getProductUpdateTemplate(HttpServletRequest request, String filepath) {
        int id = Integer.valueOf(request.getParameter("id"));

        Product product = newProduct(request, filepath);
        product.setId(id);
        return product;
    }

    @Override
    public Product newProduct(HttpServletRequest request, String filepath) {
        Product product = new Product();

        //Get parameters from HttpServletRequest
        String title = request.getParameter("title");
        BigDecimal value = setValueIfNotEmpty(request);
        String currency = request.getParameter("currency");
        Author authors = getAuthors(request);

        String isbn10 = request.getParameter("isbn10");
        String isbn13 = request.getParameter("isbn13");
        String description = request.getParameter("description");
        int productAmount = Integer.parseInt(request.getParameter("amount"));
        ProductCategory category = ProductCategory.parseCategory(request.getParameter("category"));
        String imagePath = buildImagePath(filepath);

        //Set parameters to product
        product.setTitle(title);
        product.setAuthor(authors);
        product.setValue(value);
        product.setCurrency(currency);
        product.setDescription(description);
        product.setISBN10(isbn10);
        product.setISBN13(isbn13);
        product.setProductAmount(productAmount);
        product.setCategory(category);
        product.setImagePath(imagePath);

        return product;
    }

    private BigDecimal setValueIfNotEmpty(HttpServletRequest request) {
        if (!request.getParameter("value").equals("")) {
            return new BigDecimal(request.getParameter("value"));
        }
        return new BigDecimal(0);
    }

    private String buildImagePath(String filePath) {
        return "http://java2kat.webpros.pl" + filePath;
    }

    private Author getAuthors(HttpServletRequest request) {
        String authorName = request.getParameter("authorName");
        String authorSurname = request.getParameter("authorSurname");
        return new Author(authorName, authorSurname);
    }
}
