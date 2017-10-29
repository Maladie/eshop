<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>
<jsp:include page="header.jsp"></jsp:include>
<div style="min-height: 100vh">
    <div class="container-fluid bg-3 text-center" style="min-height: 40vh; margin-top: 30px;">

        <div class="mx-auto pt-5 text-center" style="width: 400px;">
            <h2>Your shopping cart</h2>
            <a href="/basketHistory" class="btn btn-outline-success btn-block">Check your previous purchases</a>
        </div>
        <div class="row">
            <c:forEach items="${basket.getProductDtoList()}" var="product">
                <div class="col-sm-2 p-3">
                    <a href="/productDescription?product=${product.getId()}" class="productLink">
                        <img width="100"
                             src=${product.imagePath}
                             class="img-responsive" alt="Image">
                        <p>${product.title}</p>
                        <p>Quantity: ${product.getQuantity()} Total: ${product.getValue()}</p>
                        <form action="/removeProduct" method="POST">
                            <input type="hidden" name="productId" value="${product.id}">
                            <input class="btn btn-outline-danger" type="submit" value="Remove from cart"/>
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
                <form method="post" action="/basketHistory">
                    <input type="image"
                           class="w-100"
                           src="https://image.flaticon.com/icons/svg/411/411750.svg"
                           alt="Generic placeholder image">
                    <p>submit basket</p>
                </form>
            </div>
        </div>
    </div>
    </c:if>
    <c:if test="${basket.getProductDtoList().size() == 0}">
        <div class="text-center" style="min-height: 30vh; margin-top: 50px">
            <h4>Your cart is empty!</h4>
            <br>
        </div>
        <br>
    </c:if>
</div>
<jsp:include page="footer.jsp"></jsp:include>