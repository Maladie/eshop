<%@include file="header.jsp"%>
    <script src="scripts/validateLogin.js" type="text/javascript"></script>
<div class="container-fluid bg-3">
    <div class="mx-auto pt-5" style="width: 300px;">
    <form id="loginForm" action="/login" method="post">
        <div class="form-group">
            <label for="username">Username:</label><br/>
            <input class="form-control" type="text" name="userName" id="userName" required>
            <div class="invalid-feedback" id="login-feedback">
                Minimum 3 letters.
            </div>
        </div>
        <div class="form-group">
            <label for="password">Password:</label><br/>
            <input class="form-control" type="password" name="password" id="password" required>
            <div class="invalid-feedback" id="pass-feedback">
                Must be 8-20 characters long.
            </div>
        </div>
        <div class="form-group">
            <button type="submit" id="loginButton" class="btn btn-dark btn-block">Login</button>
        </div>
    </form>
    </div>
</div>
<br/>
<%@include file="footer.jsp"%>