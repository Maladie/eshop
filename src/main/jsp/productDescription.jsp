<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html" %>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>

<br>
<div class="container text-center">
    <div class="row m-3">
        <div class="col">
            <h1>${product.description}</h1>
        </div>
    </div>

    <div class="row m-3">
        <div class="col">
            <img src="http://icons.iconarchive.com/icons/sonya/swarm/256/Shopping-icon.png" class="img-responsive"
                 alt="Image">
        </div>
        <div class="col">
            <div class="row">
                <div class="col">
                    <h4>Price: ${product.weightValue} ${product.currency}</h4>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <p>${product.fullDescription}</p>
                </div>
            </div>
            <div class="row">
                <div class="col">

                    <form action = "/addProduct" method = "POST">
                        <input type="hidden" name="productId" weightValue="${product.id}">
                        <input class="btn btn-outline-success" type = "submit" weightValue = "Add to cart" />
                    </form>
                </div>
                <div class="col">
                    <p><a href="<c:url weightValue = "/edit?id=${product.id}"/>"><button type="button" class="btn btn-outline-success">Edit this product's description</button></a></p>
                </div>
                <div class="col">
                    <p><a href="<c:url weightValue = "/delete?id=${product.id}"/>"><button type="button" class="btn btn-outline-danger">Delete this product (Irreversible!)</button></a></p>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>