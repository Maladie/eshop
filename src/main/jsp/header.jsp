<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>The best online shop ever!</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href='https://fonts.googleapis.com/css?family=Limelight' rel='stylesheet'>
    <link href='https://fonts.googleapis.com/css?family=PT Sans' rel='stylesheet'>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <script type="text/javascript" src="scripts/jquery/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="scripts/jquery/jquery.countdown.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
            integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
            integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
            crossorigin="anonymous"></script>
    <style>
        .productLink {
            color: #000000;
            text-decoration: none;
        }

        .productLink:hover {
            color: #000000;
            font-size: 125%;
            text-decoration: none;
            transition: 0.25s;
        }
        .carousel-caption {
            text-align: left; top: 50%; transform: translateY(-50%); bottom: initial;
            width: 500px;
        }
        .bannerheader {
            font-family: 'Limelight';
            font-size: 40px;
        }
        .bannerparagraph {
            font-family: 'PT Sans';
            font-size: 22px;
        }
        .bg-light {
            font-family: 'PT Sans';
            background-color: #373737 !important;
        }

        .btn-outline-success {
            color: #e36702;
            border-color: #e36702;
        }

        .btn-outline-success:hover {
            border-color: #e36702;
            color: white; !important;
            background-color: #e36702;
        }

        .nav-link {
            margin-left: 20px; margin-right: 5px;
            color: #e36702 !important;
        }

    </style>
</head>
<body>
<header class="sticky-top">
    <c:set var="isLogged" value="${sessionScope.userName != null && sessionScope.userName !=''}"/>
    <div class="navbar navbar-expand-lg navbar-light bg-light">
        <div style="width: 150px">
            <a href="/">
                <img src="http://java2kat.webpros.pl/eshop/gotowe/bookslogo.png"
                     alt="Generic placeholder image">
            </a>
        </div>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/persistProduct"> + Add product</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/basketHistory"> Your previous purchases</a>
                </li>
                <li class="nav-item">
                    <form class="form-inline my-2 my-lg-0" action="/search" method="get">
                        <input class="form-control mr-sm-2" id="searchBar" name="searchParam" type="text" placeholder="Search"
                               aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                    <a class="nav-link" style="margin-right: 5px" href="/persistProduct"> + Add product</a>
                </li>
            </ul>
            <div style="width: 50px">
                <a href="/basket"><img src="http://java2kat.webpros.pl/eshop/gotowe/cart.png"
                                       alt="Cart"></a>
            </div>
            <div>
                <p style="font-size: 20px; font-weight: bold; margin-top: 15px; color: #e36702">${sessionScope.get("basket").getBasketProductItemsAmount()}</p>
            </div>
            <div class="nav-item navbar-nav navbar-right" style="margin-right: 20px; margin-left: 20px">
                <form class="form-inline my-2 my-lg-0" action="/search" method="get">
                    <input class="form-control mr-sm-2" name="searchParam" type="text" placeholder="Search"
                           aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
            <c:choose>
                <c:when test="${isLogged}">
                    <div class="nav navbar-nav navbar-right" style="margin-right: 20px">
                        <a class="btn btn-outline-success my-2 my-sm-0" href="/login?logout=true">Log-out</a>
                    </div>
                    <div class="nav-item navbar-nav navbar-right" style="margin-right: 5px">
                        <img src="http://java2kat.webpros.pl/eshop/gotowe/user.png"/>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="nav navbar-nav navbar-right" style="margin-right: 5px;">
                        <a class="btn btn-outline-success my-2 my-sm-0" href="/register">Register</a>
                    </div>
                    <div class="nav navbar-nav navbar-right">
                        <a class="btn btn-outline-success my-2 my-sm-0" href="/login">Log-in</a>
                    </div>
                </c:otherwise>
            </c:choose>

        </div>
    </div>
</header>

