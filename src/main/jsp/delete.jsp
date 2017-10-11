<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>
<jsp:include page="header.jsp"></jsp:include>

<div class="container-fliud  d-flex justify-content-center">
    <form action="/delete" method="post" class="text-center">
        <div class="form-group">
            <input type="hidden" name="id" weightValue="${product.getId()}">
            <br>
            <label>Are you sure you want to remove item?</label>
            <button type="submit" class="btn btn-outline-danger">YES</button>
        </div>
    </form>
    <div>
    <br>
    <a href="/"><button class="btn btn-outline-success">NO</button></a>
    </div>
</div><br>

<jsp:include page="footer.jsp"></jsp:include>