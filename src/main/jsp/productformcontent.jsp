<%@ page import="com.shop.model.factory.impl.ProductCategory" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col ">
    <div class="row offset-md-2">

        <div class="col-md-4 col-md-offset-2">
            <div class="form-group sr-only">
                <input type="hidden" name="id" value="${id}">
            </div>
            <div class="form-group">
                <label for="title">Title:</label>
                <input type="text" class="form-control" name="title" id="title" placeholder="Enter product title"
                       value="${product.title}" required>
            </div>
            <div class="form-group">
                <label for="authorName">Author's Name:</label>
                <input type="text" class="form-control" name="authorName" id="authorName" placeholder="Enter author name"
                       value="${product.parametersMap["author"].name}" required>
            </div>
            <div class="form-group">
                <label for="authorSurname">Author's Surname:</label>
                <input type="text" class="form-control" name="authorSurname" id="authorSurname" placeholder="Enter author surname"
                       value="${product.parametersMap["author"].surname}" required>
            </div>
        </div>
        <div class="col-md-4 col-md-offset-2">
            <div class="form-group">
                <label for="category">Category:</label>
                <c:set var="ProductCategoryValues" value="<%=ProductCategory.values()%>"/>
                <select class="form-control" id="category" name="category">
                    <c:forEach var="entry" items="${ProductCategoryValues}">
                        <option <c:if test="${product.parametersMap['category'] == entry}">selected="selected"</c:if>>${entry.name()}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="isbn13">ISBN13:</label>
                <input type="text" class="form-control" name="isbn13" id="isbn13" placeholder="Enter isbn13"
                       value="${product.parametersMap["isbn13"]}" required>
            </div>
            <div class="form-group">
                <label for="isbn10">ISBN10:</label>
                <input type="text" class="form-control" name="isbn10" id="isbn10" placeholder="Enter isbn10"
                       value="${product.parametersMap["isbn10"]}" required>
            </div>
        </div>
    </div>
    <div class="row" style="margin-top: 30px">
        <div class="col-md-4 col-md-offset-2">

            <div class="form-group">
                <label for="productAmount">Amount for Sale:</label>
                <input type="number" class="form-control" name="productAmount" id="productAmount" placeholder="Enter Amount"
                       value="${product.productAmount}" required>
            </div>
            <div class="form-group">
                <label for="value">Value:</label>
                <div class="input-group">
                    <input type="number" class="form-control" name="value" id="value" placeholder="Value"
                           value="${product.value}" required>
                    <select class="form-control selectpicker" title="currency" aria-label="currency" name="currency">
                        <option <c:if test="${product.currency == 'PLN'}">selected="selected"</c:if>>PLN</option>
                        <option <c:if test="${product.currency == 'EUR'}">selected="selected"</c:if>>EUR</option>
                        <option <c:if test="${product.currency == 'USD'}">selected="selected"</c:if>>USD</option>
                        <option <c:if test="${product.currency == 'GBP'}">selected="selected"</c:if>>GBP</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="chooseFile">Choose product image:</label>
                <div class="input-group">
                <label class="custom-file" id="chooseFile">
                    <input type="file" name="image" id="file2" class="custom-file-input">
                    <span class="custom-file-control"></span>
                </label>
                </div>
            </div>
        </div>
        <div class="col-md-4 col-md-offset-2">
            <div class="form-group">
                <label for="description">Description:</label>
                <textarea class="form-control" id="description" rows="7" name="description"
                          required>${product.description}</textarea>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-outline-success btn-block">Persist product</button>
            </div>
        </div>
    </div>
</div>