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
			<p class="new_user">New User?</p>
		</div>
		</div>
	
<!-- REGISTRATION -->

		<div class="register_wrapper hidden">
		<form:form action="/register" method="POST" modelAttribute="user" class="form">
		
		<h3>Registration</h3>
		
		<div class="form_wrapper">
		<form:input class="form_input" type="text" path="firstName" placeholder="First Name"/>
		<form:errors class="form_errors" path="firstName" />
		</div>
		
		<div class="form_wrapper">
		<form:input class="form_input" type="text" path="lastName" placeholder="Last Name"/>
		<form:errors class="form_errors" path="lastName" />
		</div>
		
		<div class="form_wrapper">
		<form:input class="form_input" type="email" path="email" placeholder="Email"/>
		<form:errors class="form_errors" path="email" />
		</div>

		<div class="form_wrapper">
		<form:input class="form_input" type="password" path="password" placeholder="Password"/>
		<form:errors class="form_errors" path="password" />
		</div>
		
		<div class="form_wrapper">
		<form:input class="form_input" type="password" path="confirmPassword" placeholder="Confirm Password"/>
		<form:errors class="form_errors" path="confirmPassword" />
		</div>
		
		<div class="form_wrapper">
		<input class="form_submit" type="submit" value="Register" />
		</div>
	</form:form>
		<a href="/login">Return to login</a>
	<div>
	
	</div>
	</div>

</div>
		
</t:template>