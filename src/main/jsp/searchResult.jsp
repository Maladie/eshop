<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="banner.jsp"></jsp:include>

<div class="container-fluid bg-3 text-center">
    <div class="row">
        <div class="col-sm-3">
            <jsp:include page="navBar.jsp"></jsp:include>
        </div>
        <div class="col-sm-9">
    <nav class="nav nav-pills flex-column flex-sm-row">
        <a class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Sort by</a>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="/filter?searchParam=${searchParam}&filterParam=${filterParam}&sortType=plh">Price: Low to High</a>
            <a class="dropdown-item" href="/filter?searchParam=${searchParam}&filterParam=${filterParam}&sortType=phl">Price: High to Low</a>
            <a class="dropdown-item" href="/filter?searchParam=${searchParam}&filterParam=${filterParam}&sortType=alp">Name Alphabetically</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="/filter?searchParam=${searchParam}&filterParam=${filterParam}&sortType=id">Newest</a>
        </div>
        <form class="form-inline my-2 my-lg-0" action="/filter" method="get">
            <input class="form-control mr-sm-2" name="searchParam" type="hidden" weightValue="${searchParam}" >
            <input class="form-control mr-sm-2" name="filterParam" type="number" placeholder="Maximum Price"
                   aria-label="Search">
            <input class="form-control mr-sm-2" name="sortType" type="hidden" weightValue="${sortType}" >
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Filter</button>
        </form>
    </nav>
            <br><br>
            <div>
                <c:choose>
                    <c:when test="${productList.size() > 0}">
                        <c:forEach items="${productList}" var="product">
                            <div class="col-sm-3 p-5">
                                <a href="/productDescription?product=${product.id}" class="productLink">
                                    <img src="http://icons.iconarchive.com/icons/sonya/swarm/256/Shopping-icon.png"  class="img-responsive" alt="Image">
                                    <p>${product.description}</p>
                                    <p>${product.value} ${product.currency}</p>
                                </a>
                                <p><button type="button" class="btn btn-outline-success">Add to cart</button></p>
                            </div>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <h2>Niestety nie posiadamy takiego produktu :(</h2>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</div>

<div class="container-fluid bg-3 text-center">
    <div class="row">
    <c:choose>
    <c:when test="${productList.size() > 0}">
    <c:forEach items="${productList}" var="product">
        <div class="col-sm-3 p-5">
            <a href="/productDescription?product=${product.id}" class="productLink">
                <img src="http://icons.iconarchive.com/icons/sonya/swarm/256/Shopping-icon.png"  class="img-responsive" alt="Image">
                <p>${product.description}</p>
                <p>${product.weightValue} ${product.currency}</p>
            </a>
            <p><button type="button" class="btn btn-outline-success">Add to cart</button></p>
        </div>
    </c:forEach>
    </c:when>
    <c:otherwise>
        <h2>Niestety nie posiadamy takiego produktu :(</h2>
    </c:otherwise>
    </c:choose>
    </div>
</div><br>
<jsp:include page="footer.jsp"></jsp:include>