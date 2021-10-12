<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/" %>



<t:template>




<div class="shopping_cart_page">

<div class="shopping_cart_part1">
	<h3>Shopping Cart</h3>
</div>
<c:forEach items="${items}" var="i">
<div class="shopping_cart_part2">

	<figure>
	<img src="${i.product.img_url}" alt="" />
	</figure>
	<div>
	<h3>${i.product.name}</h3>
	</div>
	

	
	<div>
	<p>$${i.product.price} / ${i.product.unit}</p>
	<form action="/updateQuantity/${i.id}" method="POST">
	<input class="cart_input" type="number"  name="quantity" min="1" max="100" value="${i.quantity}"/>
	<input  class="quantity" type="submit" value="Update" />
	</form>
	<h3>Total Price: ${i.totalProductPrice} </h3>
	</div>

	
	<div class="remove">
	<a href="/removeCartItem/${i.id}">Remove</a>
	</div>

</div>
</c:forEach>
<div class="shopping_cart_part3">

</div>
<a href="/checkout" class="btn_link checkout_btn">Checkout</a>
</div>


</t:template>
