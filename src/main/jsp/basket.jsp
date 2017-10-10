<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>
<jsp:include page="header.jsp"></jsp:include>

<div class="container-fluid bg-3 text-center">
    <div class="row">
        <c:forEach items="${basket}" var="product">
            <div>
                <a href="/productDescription?product=${product.getId()}" class="productLink">
                    <img src="http://icons.iconarchive.com/icons/sonya/swarm/256/Shopping-icon.png"
                         class="img-responsive" alt="Image">
                    <p>${product.getDescription()}</p>
                </a>
            </div>
        </c:forEach>
    </div>
    <div style="width: 50px">
        <form method="post" action="/basket">
            <button class="btn btn-danger">remove products</button>
            <button class="btn btn-success">place order</button>
        </form>

    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>