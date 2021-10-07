<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<t:template>



<div class="admin">

<div class="admin-box">
<h3>Make Category</h3>

<form action="/addCategory" method="POST">
<label for="category">Category Name:</label>
<input type="text" name="category" />

<input type="submit" value="ADD" />
</form>


</div>


<div class="admin-box">
<div class="produces_wrapper">
<c:forEach items="${products}" var="p">


<div class="card">

<figure >
<img class="img" src="${p.img_url}" alt="" />
</figure>

<div class="card_wrapper">

<p class="card_title">${p.name}</p>
<p class="seasonal">seasonal</p>
<div class="cart_wrapper">
<p class="card_text">$${p.price} / ${p.unit}</p>


<form action="/addToCart" method="POST">

<input type="number"  name="quantity" min="1" max="50" value="1" placeholder="Quantity"/>

<input type="hidden" name="id" value="${p.id}" />


<button type="submit"><i class="fa fa-shopping-cart">Add</i></button>
</form>
<a href="/deleteProduct/${p.id}">Delete</a>
</div>

</div>
</div>

</c:forEach>
</div>
</div>
 


<div class="admin-box">
<h3>Make Product</h3>

<form action="/admin/makeProduct" method="POST" enctype="multipart/form-data">
<div>
<label for="name">Product Name: </label>
<input type="text" name="name"/>
</div>

<div>
<label for="price">Product Price: </label>
<input type="number" name="price" step="0.01"/>
</div>

<div>
<label for="img_url">Product Image: </label>
<input type="file" name="img_url"/>
</div>

<div>
<label for="unit">Product Unit: </label>
<input type="text" name="unit"/>
</div>

<div>
<label for="description">Product Description: </label>
<input type="text" name="description"/>
</div>

<select name="category" id="">
<option value=""></option>
<c:forEach items="${categories}" var="c">
<option value="${c.id}">${c.name}</option>
</c:forEach>
</select>

<input type="submit" value="Create Product"/>

</form>

</div>
</div>





</t:template>