<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.shop.model.factory.impl.ProductCategory" %>
<c:set var="ProductCategoryValues" value="<%=ProductCategory.values()%>"/>
<link rel="stylesheet" href="styles/styles.css">
<nav class="d-block nav_item bg-nav-dark" id="nav_bar">
    <c:forEach var="entry" items="${ProductCategoryValues}">
        <a class="nav-link nav_item bg-nav-dark" id="nav_item" href="/category?category=${entry}">${entry.category}</a>
    </c:forEach>
</nav>