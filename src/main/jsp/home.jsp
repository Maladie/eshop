<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>
<jsp:include page="header.jsp"/>

<jsp:include page="banner.jsp"/>
<div class="container-fluid bg-3 text-center">
<div class="row">
    <div class="col-sm-2">
        <jsp:include page="navBar.jsp"/>
    </div>
    <div class="col-sm-10">
        <c:if test="${viewedProductList.size() != 0}">
            <h4>Last Viewed Products:</h4>
        </c:if>
        <div class="row">
            <c:forEach items="${viewedProductList}" var="product">
                <div class="col-sm-3 p-5">
                    <a href="/productDescription?product=${product.id}" class="productLink">
                        <img width="250px" src=${product.imagePath}
                                class="img-responsive" alt="Image">
                        <p class="product_title">${product.title}</p>
                        <p class="product_value" >${product.value} ${product.currency}</p>
                    </a>
                    <c:choose>
                        <c:when test="${product.productAmount == 0}">
                            <h4>Sorry! Product Unavailable!</h4>
                        </c:when>
                        <c:otherwise>
                            <form action="/addProduct" method="POST">
                                <input type="hidden" name="productId" value="${product.id}">
                                <input class="btn btn-outline-success" type="submit" value="Add to cart"/>
                            </form>
                        </c:otherwise>
                    </c:choose>
                </div>
            </c:forEach>
        </div>
        <h4>Product catalog</h4>
        <div class="row">

            <c:forEach items="${productList}" var="product">
                <div class="col-sm-4 p-5">
                    <a href="/productDescription?product=${product.id}" class="productLink">
                        <img width="250px" src='${product.imagePath}' class="img-responsive" alt="Image">
                        <p class="product_title">${product.title}</p>
                        <p class="product_value">${product.value} ${product.currency}</p>
                    </a>
                    <c:choose>
                        <c:when test="${product.productAmount == 0}">
                            <h4>Sorry! Product Unavailable!</h4>
                        </c:when>
                        <c:otherwise>
                            <form action="/addProduct" method="POST">
                                <input type="hidden" name="productId" value="${product.id}">
                                <input class="btn btn-outline-success" type="submit" value="Add to cart"/>
                            </form>
                        </c:otherwise>
                    </c:choose>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</div>
<br>
<jsp:include page="footer.jsp"/>
