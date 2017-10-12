<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
<jsp:include page="banner.jsp"></jsp:include>

<div class="container-fliud  d-flex justify-content-center">
    <form action="/edit" method="post" class="text-center">
        <div class="form-group">
            <input type="hidden" name="id" value="${product.getId()}">
            <label for="name">New Name:</label>
            <input type="text" class="form-control" name="name" id="name" value="${product.name}">
        </div>
        <div class="form-group">
            <label for="value">New Value:</label>
            <input type="number" class="form-control" name="value" id="value" value="${product.getValue()}">
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
            <label for="brand">New Brand:</label>
            <input type="text" class="form-control" name="brand" id="brand" value="${product.getParametersMap().get("brand")}">
        </div>
        <div class="form-group">
            <label for="weight">New Weight:</label>
            <input type="number" class="form-control" name="weight" id="weight" value="${product.getParametersMap().get("weight").toString()}">
        </div>
        <div class="form-group">
            <label for="weightunit">New Unit:</label>
            <select class="form-control" id="weightunit" name="weightunit">
                <option>GRAMS</option>
                <option>KILOGRAMS</option>
                <option>TONS</option>
            </select>
        </div>
        <div class="form-group">
            <label for="eclass">New Energy Consumption Class</label>
            <select class="form-control" id="eclass" name="eclass">
                <option>AAA</option>
                <option>AA</option>
                <option>A</option>
                <option>B</option>
                <option>C</option>
                <option>D</option>
            </select>
        </div>
        <div class="form-group">
            <label for="fullDescription">New Description:</label>
            <textarea class="form-control" id="fullDescription" rows="5" name="fullDescription">${product.description}</textarea>
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