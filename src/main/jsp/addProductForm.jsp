<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>
<%@include file="header.jsp" %>
<script type="text/javascript" src="scripts/validateProductForm.js"></script>

<div class="container  justify-content-center" style="margin-top: 10vh; margin-bottom: 150px">
    <h1>Add new book:</h1> <br/>
    <form action="/persistProduct" method="post" id="productform" novalidate enctype="multipart/form-data">
    <jsp:include page="productformcontent.jsp"/>
    </form>
</div><br>
<jsp:include page="footer.jsp"/>
