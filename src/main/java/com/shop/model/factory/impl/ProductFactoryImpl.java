package com.shop.model.factory.impl;

import com.shop.model.factory.ProductFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ProductFactoryImpl implements ProductFactory {

    @Override
    public Product getProductUpdateTemplate(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id"));

        Product product = newProduct(request);
        product.setId(id);
        return product;
    }

    @Override
    public Product newProduct(HttpServletRequest request) {
        Product product = new Product();

        //Get parameters from HttpServletRequest
        String title = request.getParameter("title");
        BigDecimal value = setValueIfNotEmpty(request);
        String currency = request.getParameter("currency");
        // ? Todo.. bierzemy pierwszego czy wszystkich ?
        List<Author> authors = getAuthors(request);

        long isbn13 = Long.parseLong(request.getParameter("isbn13"));
        String description = request.getParameter("description");
        int productAmount = Integer.valueOf(request.getParameter("amount"));
        ProductCategory category = ProductCategory.parseCategory(request.getParameter("category"));
        String imagePath = buildImagePath(request);

        //Set parameters to product
        product.setTitle(title);
        product.setAuthor(authors);
        product.setValue(value);
        product.setCurrency(currency);
        product.setDescription(description);
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

    private String buildImagePath(HttpServletRequest request) {
        Part filePart = null;
        String fileName = null;
        try {
            filePart = request.getPart("image");
        } catch (IOException | ServletException e) {
            e.printStackTrace();
            fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        }
        return "http://java2kat.webpros.pl" + fileName;
    }

    private List<Author> getAuthors(HttpServletRequest request){
        String authorName = request.getParameter("authorName");
        String authorSurname = request.getParameter("authorSurname");
        return Arrays.asList(new Author(authorName, authorSurname));
    }
}
