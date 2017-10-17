<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>
<%@include file="header.jsp" %>
<script type="text/javascript" src="scripts/validate.js"></script>

<div class="container  justify-content-center" style="margin-top: 100px; margin-bottom: 150px">
    <form action="/register" method="post" id="productform" novalidate>
        <div class="row ">
            <div class="col-md-3">
                <div class="form-group">
                    <label for="firstname">Name:</label>
                    <input type="text" class="form-control" name="firstname" id="firstname" placeholder="Your name" required>
                </div>
                <div class="form-group">
                    <label for="surname">Surname:</label>
                    <input type="text" class="form-control" name="surname" id="surname" placeholder="Your surname" required>
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group">
                    <label for="username">Username:</label>
                    <input type="text" class="form-control" name="username" id="username" placeholder="Your username" required>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control" name="password" id="password" placeholder="Your password" required>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-outline-success btn-block">Create new account</button>
                </div>
            </div>
        </div>
    </form>
</div><br>
<jsp:include page="footer.jsp"/>