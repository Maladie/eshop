<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>
<jsp:include page="header.jsp"></jsp:include>

<div class="container-fluid bg-3 text-center">
    <h2>Your shopping cart</h2>
    <div class="row">
        <c:forEach items="${basket.getProductDtoList()}" var="product">
            <div class="col-sm-2 p-3">
                <a href="/productDescription?product=${product.getId()}" class="productLink">
                    <img height="30" width="30"
                         src="http://icons.iconarchive.com/icons/sonya/swarm/256/Shopping-icon.png"
                         class="img-responsive" alt="Image">
                    <p>${product.getDescription()}</p>
                    <p>Amount: ${product.getQuantity()} Total: ${product.getValue()}</p>
                    <form action = "/removeProduct" method = "POST">
                        <input type="hidden" name="productId" value="${product.id}">
                        <input class="btn btn-outline-danger" type = "submit" value = "Remove from cart" />
                    </form>
                </a>
            </div>
            <br>
        </c:forEach>
    </div>
    <c:if test="${basket.getProductDtoList().size() != 0}">
    <div class="d-flex justify-content-around">
        <div style="width: 50px">
        <img class="w-100"
             src="https://image.flaticon.com/icons/svg/547/547171.svg"
             alt="Generic placeholder image">
            Total Amount: ${basket.getTotal()}
        </div>
        <div style="width: 50px">
            <form method="post" action="/basket">
                <input type="image" class="w-100" src="https://image.flaticon.com/icons/svg/590/590497.svg">
                <a>Remove products</a>
            </form>
        </div>
        <div style="width: 50px">
            <img class="w-100"
                 src="https://image.flaticon.com/icons/svg/411/411750.svg"
                 alt="Generic placeholder image">
        </div>
    </div>
    </c:if>
    <c:if test="${basket.getProductDtoList().size() == 0}">
    <br>
    <h4>Your cart is empty!</h4>
    <br>
    <br>
    </c:if>
<jsp:include page="footer.jsp"></jsp:include>