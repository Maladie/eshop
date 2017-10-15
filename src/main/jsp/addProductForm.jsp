<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>
<jsp:include page="header.jsp"></jsp:include>

<div class="container-fliud  d-flex justify-content-center">
    <form action="/persistProduct" method="post" class="text-center">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" name="name" id="name" placeholder="Enter product name">
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
            <label for="category">Category:</label>
            <select class="form-control" id="category" name="category" >
                <option>DISHWASHER</option>
                <option>FREEZER</option>
                <option>KETTLE</option>
                <option>MICROWAVE_OVEN</option>
                <option>OVEN</option>
                <option>REFRIGERATOR</option>
                <option>WASHING_MACHINE</option>
                <option selected="selected">OTHER</option>
            </select>
        </div>
        <div class="form-group">
            <label for="brand">Brand:</label>
            <input type="text" class="form-control" name="brand" id="brand" placeholder="Enter brand name">
        </div>
        <div class="form-group">
            <label for="weight">Weight:</label>
            <input type="number" class="form-control" name="weight" id="weight" placeholder="Enter weight of product">
        </div>
        <div class="form-group">
            <label for="weightunit">Unit:</label>
            <select class="form-control" id="weightunit" name="weightunit">
                <option>GRAMS</option>
                <option>KILOGRAMS</option>
                <option>TONES</option>
            </select>
        </div>
        <div class="form-group">
            <label for="eclass">Energy Consumption Class</label>
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
            <label for="description">Description:</label>
            <textarea class="form-control" id="description" rows="5" name="description"></textarea>
        </div>
        <div class="form-group">
            <label for="amount">Amount for Sale:</label>
            <input type="number" class="form-control" name="amount" id="amount" placeholder="Enter Amount">
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
