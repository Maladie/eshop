<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>
<jsp:include page="header.jsp"/>

<jsp:include page="banner.jsp"/>
<div class="container-fluid bg-3 text-center">
<div class="row">
    <div class="col-sm-3">
        <jsp:include page="navBar.jsp"/>
    </div>
    <div class="col-sm-9">
        <c:if test="${viewedProductList.size() != 0}">
            <h5>Last Viewed Products</h5>
        </c:if>
        <div class="row">
            <c:forEach items="${viewedProductList}" var="product">
                <div class="col-sm-4 p-5">
                    <a href="/productDescription?product=${product.id}" class="productLink">
                        <img src="http://icons.iconarchive.com/icons/sonya/swarm/256/Shopping-icon.png"
                             class="img-responsive" alt="Image">
                        <p>${product.name}</p>
                        <p>${product.value} ${product.currency}</p>
                    </a>
                    <form action="/addProduct" method="POST">
                        <input type="hidden" name="productId" value="${product.id}">
                        <input class="btn btn-outline-success" type="submit" value="Add to cart"/>
                    </form>
                </div>
            </c:forEach>
        </div>
        <h5>Product catalog</h5>
        <div class="row">

            <c:forEach items="${productList}" var="product">
                <div class="col-sm-4 p-5">
                    <a href="/productDescription?product=${product.id}" class="productLink">
                        <img src="http://icons.iconarchive.com/icons/sonya/swarm/256/Shopping-icon.png"
                             class="img-responsive" alt="Image">
                        <p>${product.name}</p>
                        <p>${product.value} ${product.currency}</p>
                    </a>

                    <form action="/addProduct" method="POST">
                        <input type="hidden" name="productId" value="${product.id}">
                        <input class="btn btn-outline-success" type="submit" value="Add to cart"/>
                    </form>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</div>
<br>
<jsp:include page="footer.jsp"/>
