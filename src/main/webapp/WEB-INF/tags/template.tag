<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Echo Valley Farm</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/main.css" />
</head>
<body>
<!-- NAVBAR -->

<nav class="navbar">
<ul class="navbar_list">
	<li class="logo"><a class="navbar_logo" href="/">EVF</a></li>

	<!-- <li class="navbar_item"><a class="navbar_link" href="/profile">Profile</a></li> -->

	<li class="navbar_item"><a class="navbar_link"" href="/products">Produce</a></li>
	<li class="navbar_item"><a class="navbar_link"" href="/logout">Logout</a></li>
	<li class="navbar_item"><a class="navbar_link" href="/login">Login</a></li>
	<li class="navbar_item"><a class="shopping_cart cart-font" href="/shoppingCart">Cart<i class="fa fa-shopping-cart"><span class="cart_number">${items.size()}</span></i></a></li>
</ul>

</nav>

<jsp:doBody />

<!-- FOOTER -->
<footer class="footer">
<h2>echo valley farm</h2>

<ul class="footer_list">
<li class="footer_item"><a class="footer_link" href="#">echovalleyff.com</a></li>
<li class="footer_item"><a class="footer_link" href="#">facebook</a></li>
<li class="footer_item"><a class="footer_link" href="#">instragram</a></li>
</ul>

<p class="copyright">&copy; Copyright 2021 by Huynh Nguyen</p>
<p class="copyright">All rights reserved</p>
</footer>

</body>
<script src="js/log_reg.js"></script>
</html>