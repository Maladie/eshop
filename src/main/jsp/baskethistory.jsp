<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>


<jsp:include page="header.jsp"></jsp:include>

<div class="container-fluid bg-3 text-center">

    <h2>Submitted Baskets</h2>

    <c:forEach items="${submittedBaskets.getSubmittedBaskets()}" var="basket">
        <div class="row">
            <div class="col-sm-2">
                <h5>Basket</h5>
                <p></p>
                <img width="100"
                     height="100"
                     src="https://image.flaticon.com/icons/png/512/2/2772.png"
                     alt="Generic placeholder image">
            </div>
            <c:forEach items="${basket.getProductDtoList()}" var="product">
                <div class="col-sm-2 p-3">
                    <a href="/productDescription?product=${product.getId()}" class="productLink">
                        <img height="30" width="30"
                             src="http://icons.iconarchive.com/icons/sonya/swarm/256/Shopping-icon.png"
                             class="img-responsive" alt="Image">
                        <p>${product.getName()}</p>
                        <p>Quantity: ${product.getQuantity()} Total: ${product.getValue()}</p>
                    </a>
                </div>
            </c:forEach>
            <br>
        </div>
    </c:forEach>

    <c:if test="${submittedBaskets.getSubmittedBaskets().size() == 0}">
        <br>
        <h4>You have not submitted any baskets yet!</h4>
        <br>
        <br>
    </c:if>
</div>


<jsp:include page="footer.jsp"></jsp:include>