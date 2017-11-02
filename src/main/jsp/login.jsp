<%@include file="header.jsp" %>
<script src="scripts/validateLogin.js" type="text/javascript"></script>
<div class="container-fluid bg-3" style="min-height: 50vh;">
    <div class=" mx-auto pt-5" style="width: 300px; ">
        <div class="alert alert-success" role="alert">
            Successfully logged-in
            <div id="clock" class="text-centered">
            </div>
        </div>
        <div class="alert alert-danger" role="alert">
            Incorrect username or password!
        </div>
        <form id="loginForm">
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
<%@include file="footer.jsp" %>