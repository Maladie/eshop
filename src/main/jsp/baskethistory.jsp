<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>


<jsp:include page="header.jsp"></jsp:include>

<div class="container-fluid bg-3 text-center" style="min-height: 50vh; margin-top: 20px">

    <h2>Submitted Baskets</h2>

    <c:forEach items="${submittedBaskets}" var="basket">
        <div class="row">
            <div class="col-sm-2"><c:set var="stringDate" value="${basket.submitDate}" />
                <fmt:parseDate value="${basket.submitDate}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
                <h5>Basket <br/>
                    <fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${ parsedDateTime }" /></h5>
                <img width="80"
                     height="80"
                     src="https://image.flaticon.com/icons/png/512/2/2772.png"
                     alt="Generic placeholder image"><br/>
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

    <c:if test="${submittedBaskets == null}">
        <div class="text-center" style="margin-top: 20px">
        <h4>You have not submitted any baskets yet!</h4>
        <br>
        <br>
        </div>
    </c:if>
</div>


<jsp:include page="footer.jsp"></jsp:include>