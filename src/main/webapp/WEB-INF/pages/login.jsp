<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<t:template>

		
<div class="log_reg_container">
<!-- LOGIN -->
	<div class="login_wrapper">

		<form method="POST" action="/login" class="form">
				<h3>Login</h3>
				<span class="checkout_error">${login_error}</span>
			<span class="login_errors">${error}</span>
			<div class="form_wrapper">
			<label class="form_label" for="email">Email: </label>
				<input class="form_input" type="email" name="email" placeholder="Email"/>
			</div>
			<div class="form_wrapper">
			<label class="form_label" for="email">Password: </label>
				<input  class="form_input" type="password" name="password" placeholder="Password"/>
			</div>
			<div class="form_wrapper">
				<input class="form_submit" type="submit" value="Login"/>
			</div>
		</form>
		<div>
			<a href="">Password Recovery</a>
			<a href="/register">New User?</a>
		</div>
		</div>
</div>
		
</t:template>