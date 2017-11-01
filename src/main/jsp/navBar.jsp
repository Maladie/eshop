<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.shop.model.factory.impl.ProductCategory" %>
<c:set var="ProductCategoryValues" value="<%=ProductCategory.values()%>"/>
<nav class="d-block bg-dark" id="nav_bar">
    <div class="container">
    <ul class="nav nav-pills flex-column">
        <c:forEach var="entry" items="${ProductCategoryValues}">
        <li class="nav-item">
            <a class="nav-link active bg-dark" href="/category?category=${entry}">${entry.category}</a>
        </li>
        </c:forEach>
    </ul>
    </div>
</nav>