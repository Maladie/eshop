<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="banner.jsp"></jsp:include>
<script type="text/javascript" src="scripts/validateProductForm.js"></script>

<div class="container-fliud justify-content-center">
    <form action="/edit" method="post" class="text-center" id="productform" style="min-height: 80vh; margin-top: 15vh" novalidate>
        <jsp:include page="productformcontent.jsp"/>
    </form>
</div><br>
<jsp:include page="footer.jsp"></jsp:include>