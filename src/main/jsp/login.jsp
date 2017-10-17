<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>

<div class="container-fluid bg-3">
    <div class="mx-auto pt-5" style="width: 200px;">

    <form id="loginform" action="/login" method="post">
        <div class="form-group">
            <label for="username">Username:</label><br/>
            <input class="form-control" type="text" name="username" id="username" required>
        </div>
        <div class="form-group">
            <label for="password">Password:</label><br/>
            <input class="form-control" type="password" name="password" id="password" required>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-dark">Login</button>
        </div>
    </form>
    </div>
</div>
<br/>
