<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>
<jsp:include page="header.jsp"></jsp:include>

<div class="container-fluid bg-3 text-center">
<c:forEach items="${basket}" var="product">
    <div class="row">
    <div>
    <a href="/productDescription?product=${product.id}" class="productLink">
    <img src="http://icons.iconarchive.com/icons/sonya/swarm/256/Shopping-icon.png"  class="img-responsive" alt="Image">
    <p>${product.description}</p>
    <p>${product.value} ${product.currency}</p>
    </a>
    </div>
    </c:forEach>
    </div>
    </div>
<jsp:include page="footer.jsp"></jsp:include>