<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Echo Valley Family Farm</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
<link rel="stylesheet" href="css/main.css" />
</head>
<body>
<!-- NAVBAR -->

<nav class="navbar display">
<ul class="navbar_list">
	<li class="logo"><a class="navbar_logo" href="/">EVFF</a></li>
	<li class="navbar_item _profile"><a class="navbar_link" href="/profile">Profile</a></li>
	<li class="navbar_item _produce"><a class="navbar_link" href="/products">Produce</a></li>
	<li class="navbar_item _logout"><a class="navbar_link" href="/logout">Logout</a></li>
	<li class="navbar_item _login"><a class="navbar_link" href="/login">Login</a></li>
	<li class="navbar_item"><a class="shopping_cart font" href="/shoppingCart"><i class="fas fa-shopping-cart"><span class="cart_quantity">${items.size()}</span></i></a></li>
</ul>

</nav>

<jsp:doBody />

<!-- FOOTER -->
<footer class="footer">
<h2>echo valley farm</h2>

<ul class="footer_list">
<li class="footer_item"><a class="footer_link" href="#"><i class="fab fa-facebook"></i></a></li>
<li class="footer_item"><a class="footer_link" href="#"><i class="fab fa-instagram"></i></a></li>
</ul>

<p class="copyright">&copy; Copyright 2021 by Huynh Nguyen</p>
<p class="copyright">All rights reserved</p>
</footer>

</body>
<script src="js/log_reg.js"></script>
</html>