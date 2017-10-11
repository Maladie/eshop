<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
<jsp:include page="banner.jsp"></jsp:include>

<div class="container-fliud  d-flex justify-content-center">
    <form action="/edit" method="post" class="text-center">
        <div class="form-group">
            <input type="hidden" name="id" weightValue="${product.getId()}">
            <label for="description">New Name:</label>
            <input type="text" class="form-control" name="description" id="description" weightValue="${product.description}">
        </div>
        <div class="form-group">
            <label for="weightValue">New Value:</label>
            <input type="number" class="form-control" name="weightValue" id="weightValue" weightValue="${product.getValue()}">
        </div>
        <div class="form-group">
            <label for="currency">New Currency:</label>
            <select class="form-control" id="currency" name="currency">
                <option>PLN</option>
                <option>EUR</option>
                <option>USD</option>
                <option>GBP</option>
            </select>
        </div>
        <div class="form-group">
            <label for="fullDescription">New Description:</label>
            <textarea class="form-control" id="fullDescription" rows="5" name="fullDescription">${product.fullDescription}</textarea>
        </div>
        <div class="form-group">
            <label for="chooseFile">Choose product image:</label>
            <br>
            <label class="custom-file" id="chooseFile">
                <input type="file" name="image" id="file2" class="custom-file-input">
                <span class="custom-file-control"></span>
            </label>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-outline-success">Edit product</button>
        </div>
    </form>
</div><br>
<jsp:include page="footer.jsp"></jsp:include>