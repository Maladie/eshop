<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>
<%@include file="header.jsp" %>
<script type="text/javascript" src="scripts/validate.js"></script>

<div class="container-fliud  d-flex justify-content-center">
    <form action="/persistProduct" method="post" class="text-center" id="productform" novalidate>
    <jsp:include page="productformcontent.jsp"/>
    </form>
</div><br>
<jsp:include page="footer.jsp"/>
