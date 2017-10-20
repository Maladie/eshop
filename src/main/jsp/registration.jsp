<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>
<%@include file="header.jsp" %>
<script type="text/javascript" src="scripts/validateRegister.js"></script>
<script type="text/javascript" src="scripts/jquery/jquery-3.2.1.min.js"></script>
<div class="container  justify-content-center" style="margin-top: 100px; margin-bottom: 150px">
    <form action="/register" method="post" id="registerForm" novalidate>
        <div class="row ">
            <div class="col-md-3">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" class="form-control is-invalid" name="name" id="name" placeholder="Your name" required>
                    <div class="invalid-feedback" id="name-feedback">
                        Cannot be empty
                    </div>
                </div>
                <div class="form-group">
                    <label for="surname">Surname:</label>
                    <input type="text" class="form-control is-invalid" name="surname" id="surname" placeholder="Your surname"
                           required>
                    <div class="invalid-feedback" id="surname-feedback">
                        Cannot be empty
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group">
                    <label for="userName">Username:</label>
                    <input type="text" class="form-control is-invalid" name="userName" id="userName" placeholder="Your username"
                           required>
                    <div class="invalid-feedback" id="userName-feedback">
                        Minimum 3 letters.
                    </div>
                    <div class="invalid-feedback" id="userName-used-feedback">
                        Username already used.
                    </div>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control is-invalid" name="password" id="password"
                           placeholder="Your password" required>
                    <div class="invalid-feedback" id="pass-feedback">
                        Minimum 8 characters.
                    </div>
                </div>
                <div class="form-group">
                    <button type="submit" id="submitbtn" class="btn btn-outline-success btn-block">Create new account
                    </button>
                </div>
            </div>
        </div>
    </form>
</div>
<br>
<jsp:include page="footer.jsp"/>