<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
<jsp:include page="banner.jsp"></jsp:include>
<div class="container-fluid bg-3 text-center">
    <c:if test="${viewedProductList.size() != 0}">
        <h5>Last Viewed Products</h5>
    </c:if>
    <div class="row">
        <c:forEach items="${viewedProductList}" var="product">
            <div class="col-sm-3 p-5">
                <a href="/productDescription?product=${product.id}" class="productLink">
                    <img src="http://icons.iconarchive.com/icons/sonya/swarm/256/Shopping-icon.png"
                         class="img-responsive" alt="Image">
                    <p>${product.description}</p>
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
            <div class="col-sm-3 p-5">
                <a href="/productDescription?product=${product.id}" class="productLink">
                    <img src="http://icons.iconarchive.com/icons/sonya/swarm/256/Shopping-icon.png"
                         class="img-responsive" alt="Image">
                    <p>${product.description}</p>
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
<br>
<jsp:include page="footer.jsp"></jsp:include>
