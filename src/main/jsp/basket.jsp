<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>
<jsp:include page="header.jsp"></jsp:include>

<div class="container-fluid bg-3 text-center">
    <h2>Your shopping cart</h2>
    <div class="row">
        <c:forEach items="${basket}" var="product">
            <div class="col-sm-2 p-3">
                <a href="/productDescription?product=${product.getId()}" class="productLink">
                    <img height="30" width="30"
                         src="http://icons.iconarchive.com/icons/sonya/swarm/256/Shopping-icon.png"
                         class="img-responsive" alt="Image">
                    <p>${product.getDescription()}</p>
                    <p>Amount: ${product.getQuantity()} Total: ${product.getValue()}</p>
                </a>
            </div>
            <br>
        </c:forEach>
    </div>
    <div class="row">
        <div class="col-sm-3 p-5">
            <div style="width: 50px">
                <a><img class="w-100" src="https://image.flaticon.com/icons/svg/547/547171.svg"
                        alt="Total">
                    Total Amount: ${itemList.getTotal()}
            </div>
            </a>
        </div>
        <div class="col-sm-3 p-5">
            <div class="row">
                <div style="width: 50px">
                    <form method="post" action="/basket">
                        <input type="image" class="w-100" src="https://image.flaticon.com/icons/svg/590/590497.svg">
                        <a>Remove products</a>
                    </form>
                </div>
            </div>
        </div>
        <div style="width: 50px">
        </div>
    </div>
<jsp:include page="footer.jsp"></jsp:include>