<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>
<jsp:include page="header.jsp"/>
<br>
<div class="container-fluid bg-3 text-center">
    <div class="row">
        <div class="col-sm-3">
            <jsp:include page="navBar.jsp"/>
        </div>
        <div class="col-sm-9">
    <div class="row m-3">
        <div class="col">
            <h1>${product.name}</h1>
        </div>
    </div>

    <div class="row m-3">
        <div class="col">
            <img src="http://icons.iconarchive.com/icons/sonya/swarm/256/Shopping-icon.png" class="img-responsive"
                 alt="Image">
        </div>
        <div class="col">
            <div class="row">
                <div class="col">
                    <h4>Price: ${product.value} ${product.currency}</h4>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <p>${product.description}</p>
                    <p>${product.parametersMap.get("brand")}</p>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <c:choose>
                        <c:when test="${product.productAmount == 0}">
                            <h3>Sorry! Product Unavailable!</h3>
                        </c:when>
                        <c:otherwise>
                            <form action="/addProduct" method="POST">
                                <input type="hidden" name="productId" value="${product.id}">
                                <input class="btn btn-outline-success" type="submit" value="Add to cart"/>
                            </form>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="col">
                    <p><a href="<c:url value = "/edit?id=${product.id}"/>"><button type="button" class="btn btn-outline-success">Edit this product's name</button></a></p>
                </div>
                <div class="col">
                    <p><a href="<c:url value = "/delete?id=${product.id}"/>"><button type="button" class="btn btn-outline-danger">Delete this product (Irreversible!)</button></a></p>
                </div>
            </div>
        </div>
    </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>