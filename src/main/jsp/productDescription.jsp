<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>
<jsp:include page="header.jsp"/>
<br>
<div class="container-fluid bg-3 text-center">
    <div class="row">
        <div class="col-sm-2">
            <jsp:include page="navBar.jsp"/>
        </div>
        <div class="col-sm-9">
            <div class="row m-3">
                <div class="col">
                    <h1>${product.title}</h1>
                </div>
            </div>

            <div class="row m-3">
                <div class="col">
                    <img src=${product.imagePath}
                         class="img-responsive"
                         alt="Image">
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
                                    <form action="/addProduct" method="POST">
                                        <input type="hidden" name="productId" value="${product.id}">
                                        <input class="btn btn-outline-success" type="submit" value="Add to cart"/>
                                    </form>
                                </div>
                                <div class="col">
                                    <p><a href="<c:url value = "/edit?id=${product.id}"/>">
                                        <button type="button" class="btn btn-outline-success">Edit this product's name
                                        </button>
                                    </a></p>
                                </div>
                                <div class="col">
                                    <p><a href="<c:url value = "/delete?id=${product.id}"/>">
                                        <button type="button" class="btn btn-outline-danger">Delete this product
                                            (Irreversible!)
                                        </button>
                                    </a></p>
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