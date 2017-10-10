<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>
<jsp:include page="header.jsp"></jsp:include>

<div class="container-fliud  d-flex justify-content-center">
    <form action="/persistProduct" method="post" class="text-center">
        <div class="form-group">
            <label for="description">Name:</label>
            <input type="text" class="form-control" name="description" id="description" placeholder="Enter product name">
        </div>
        <div class="form-group">
            <label for="value">Value:</label>
            <input type="number" class="form-control" name="value" id="value" placeholder="Enter product value">
        </div>
        <div class="form-group">
            <label for="currency">Currency:</label>
            <select class="form-control" id="currency" name="currency">
                <option>PLN</option>
                <option>EUR</option>
                <option>USD</option>
                <option>GBP</option>
            </select>
        </div>
        <div class="form-group">
            <label for="fullDescription">Full description:</label>
            <textarea class="form-control" id="fullDescription" rows="5" name="fullDescription"></textarea>
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
            <button type="submit" class="btn btn-outline-success">Persist product</button>
        </div>
    </form>
</div><br>
<jsp:include page="footer.jsp"></jsp:include>
