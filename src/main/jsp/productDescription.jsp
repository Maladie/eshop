<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>
<jsp:include page="header.jsp"/>
<link href="styles/styles.css" rel="stylesheet">
<div class="container-fluid bg-3 text-center" style="min-height: 100vh">
    <div class="row" style="margin-top: 10vh">
        <div class="col-sm-2">
            <jsp:include page="navBar.jsp"/>
        </div>
        <div class="col-sm-9">
            <div class="row m-3">
                <div class="col " style="margin-bottom: 3vh">
                    <h1>${product.title}</h1>
                </div>
            </div>

            <div class="row m-3">
                <div class="col-md-4">
                    <div class="row" style="margin-bottom: 15px">
                        <div class="col img-desc">
                            <img src='${product.imagePath}' class="img-responsive" alt="Image">
                        </div>
                    </div>
                    <div class="row-fluid row-sm-offset-2">
                        <div class="col">
                            <form action="/addProduct" method="POST">
                                <input type="hidden" name="productId" value="${product.id}">
                                <input class="btn btn-outline-success btn-block" type="submit" value="Add to cart"/>
                            </form>
                        </div>
                    </div>
                    <c:if test="${sessionScope.get('admin')== true}">
                        <div class="row-fluid row-sm-offset-2">
                            <div class="col">
                                <button onclick="window.location.href='/edit?id=${product.id}'"
                                        class="btn btn-outline-success btn-block btn_top_offset">Edit this product's name
                                </button>
                            </div>
                        </div>
                        <div class="row-fluid row-sm-offset-2">
                            <div class="col">
                                <button type="button" onclick="window.location.href='/delete?id=${product.id}'"
                                        class="btn btn-outline-danger btn-block btn_top_offset">Delete this product (Irreversible!)
                                </button>
                            </div>
                        </div>
                    </c:if>
                </div>
                <div class="col">
                    <c:choose>
                        <%--when product not found--%>
                        <c:when test="${product.productAmount == 0 || productremovederror !=null}">
                            <div class="text-center col-md-4" style="margin-top: 50px">
                                <h3>Sorry! Product Unavailable!</h3><br/>
                                <a href="/">
                                    <button type="button" class="btn btn-dark btn-block">Back to home :(</button>
                                </a>
                            </div>
                        </c:when>
                        <%--normal display view--%>
                        <c:otherwise>
                            <div class="row">
                                <div class="col text-left">
                                    <h4>Author:</h4>
                                    <p> ${product.parametersMap["author"].name} ${product.parametersMap["author"].surname}</p>
                                    <br/>
                                    <h5>ISBN10:</h5>
                                    <p>${product.parametersMap["isbn10"]}</p><br/>
                                    <h5>ISBN13:</h5>
                                    <p>${product.parametersMap["isbn13"]}</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col text-left">
                                    <h4>Category: </h4>
                                    <p>${product.parametersMap["category"].getCategory()}</p>
                                </div>
                                <div class="col text-left">
                                    <h4>Price: </h4>
                                    <p>${product.value} ${product.currency}</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col text-left">
                                    <h4>Description: </h4>
                                    <p>${product.description}</p>
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>