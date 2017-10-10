<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>
<jsp:include page="header.jsp"></jsp:include>

<div class="container-fluid bg-3 text-center">
    <div class="row">
        <c:forEach items="${basket}" var="product">
            <div>
                <a href="/productDescription?product=${product.getId()}" class="productLink">
                    <img height="30" width="30" src="http://icons.iconarchive.com/icons/sonya/swarm/256/Shopping-icon.png"
                         class="img-responsive" alt="Image">
                    <p>${product.getDescription()} Amount: ${product.getQuantity()}</p>
                </a>
            </div>
        </c:forEach>
    </div>
    <div style="width: 50px">
        <a><img class="w-100"
                src="https://image.flaticon.com/icons/svg/590/590497.svg"
                alt="RemoveCart">Remove products</a>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>