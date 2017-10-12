<!DOCTYPE html>
<html lang="en">
<head>
    <title>The best online shop ever!</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
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
    </style>
</head>
<body>
<header class="sticky-top">
    <div class="navbar navbar-expand-lg navbar-light bg-light">
        <div style="width: 150px">
            <a href="/">
            <img class="w-100"
                 src="https://cdn.dribbble.com/users/64815/screenshots/1518220/attachments/229248/shop_logo_big.png"
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
                        <input class="form-control mr-sm-2" name="searchParam" type="text" placeholder="Search"
                               aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </li>
            </ul>
            <div style="width: 50px">
                <a href="/basket"><img class="w-100"
                     src="https://image.flaticon.com/icons/png/512/2/2772.png"
                                       alt="Cart"></a>
            </div>
            <div>
                <p style="font-size: 30px; font-weight: bold;">${sessionScope.get("basket").getBasketProductItemsAmount()}</p>
            </div>
            <ul></ul>
            <ul class="nav navbar-nav navbar-right">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Log-in</button>
            </ul>
        </div>
    </div>
</header>

