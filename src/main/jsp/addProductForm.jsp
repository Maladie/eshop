<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>
<%@include file="header.jsp" %>
<script type="text/javascript" src="scripts/validateProductForm.js"></script>

<div class="container  justify-content-center" style="margin-top: 100px; margin-bottom: 150px">
    <form action="/persistProduct" method="post" id="productform" novalidate>
    <jsp:include page="productformcontent.jsp"/>
    </form>
</div><br>
<jsp:include page="footer.jsp"/>
