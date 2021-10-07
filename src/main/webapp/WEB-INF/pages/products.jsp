<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<t:template>

<main class="produces">


<div class="produces_wrapper">
<c:forEach items="${products}" var="p">
<div class="card">
	<figure >
	<img class="img" src="${p.img_url}" alt="" />
	</figure>

	<div class="card_wrapper">
	<p class="card_title">${p.name}</p>
	<p class="seasonal">seasonal</p>
	<p class="card_text">$${p.price} / ${p.unit}</p>
	
	<form class="cart_form" action="/addToCart" method="POST">
	<input class="cart_input" type="number"  name="quantity" min="1" max="50" value="1"/>
	
	<input class="cart_input" type="hidden" name="id" value="${p.id}" />
	<button class="cart_btn" type="submit">ADD TO CART</button>
	</form>
</div>

</div>
</c:forEach>
</div>


</main>

</t:template>
