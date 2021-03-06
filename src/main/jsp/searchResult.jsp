<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="banner.jsp"></jsp:include>

<div class="container-fluid bg-3 text-center">
    <div class="row">
        <div class="col-sm-2">
            <jsp:include page="navBar.jsp"></jsp:include>
        </div>
        <div class="col-sm-10">
    <nav class="nav nav-pills flex-column flex-sm-row">
        <a class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" style="color: #ed6702 !important;">Sort by</a>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="/filter?searchParam=${searchParam}&category=${category}&filterParam=${filterParam}&sortType=plh">Price: Low to High</a>
            <a class="dropdown-item" href="/filter?searchParam=${searchParam}&category=${category}&filterParam=${filterParam}&sortType=phl">Price: High to Low</a>
            <a class="dropdown-item" href="/filter?searchParam=${searchParam}&category=${category}&filterParam=${filterParam}&sortType=alp">Name Alphabetically</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="/filter?searchParam=${searchParam}&category=${category}&filterParam=${filterParam}&sortType=id">Newest</a>
        </div>
        <form class="form-inline my-2 my-lg-0" action="/filter" method="get">
            <input class="form-control mr-sm-2" name="searchParam" type="hidden" value="${searchParam}" >
            <input class="form-control mr-sm-2" name="category" type="hidden" value="${category}" >
            <input class="form-control mr-sm-2" name="filterParam" type="number" placeholder="Maximum Price"
                   aria-label="Search">
            <input class="form-control mr-sm-2" name="sortType" type="hidden" value="${sortType}" >
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Filter</button>
        </form>
    </nav>
            <br><br>
            <div class="row" style="min-height: 70vh;">
                <c:choose>
                    <c:when test="${productList.size() > 0}">
                        <c:forEach items="${productList}" var="product">
                            <div class="col-sm-3 p-5">
                                <a href="/productDescription?product=${product.id}" class="productLink">
                                    <img width="250px" src=${product.imagePath}  class="img-responsive" alt="Image">
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
                    </c:when>
                    <c:otherwise>
                        <div class="text-center" style="margin-left: 20px">
                        <h2>Sorry, we couldn't find anything :(</h2>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>