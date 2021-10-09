<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<t:template>

<div class="log_reg_container">
	
<!-- REGISTRATION -->

		<div class="register_wrapper">
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