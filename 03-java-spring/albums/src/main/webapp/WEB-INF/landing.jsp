<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div class="container">
	<h1>Welcome to Albums dot com</h1>
		<div class="row">
			<div class="column">
			<h3>Register</h3>
				<form:form method="POST" action="/registerUser" modelAttribute="user">
				<form:label path="firstName"> First name</form:label>
				<form:errors path="firstName"/>
				<form:input type="text" path="firstName"/>
				<br>
				<form:label path="lastName"> Last name</form:label>
				<form:errors path="lastName"/>
				<form:input type="text" path="lastName"/>
				<br>
				<form:label path="email"> Email</form:label>
				<form:errors path="email"/>
				<form:input type="email" path="email"/>
				<br>
				<form:label path="password"> Password</form:label>
				<form:errors path="password"/>
				<form:input type="password" path="password"/>
				<br>
				<form:label path="confirmPassword"> Confirm password</form:label>
				<form:errors path="confirmPassword"/>
				<form:input type="password" path="confirmPassword"/>
				<br>
				<input type="submit" value="submit"/>
			</form:form>
			</div>
			<div class="column">
			<h3>Login</h3>
			<p>${loginError}</p>
				<form action="/login" method="POST">
				<label>Email Address</label>
				<input type="email" name="lemail">
				<label>Password</label>
				<input type="password" name="lpassword">
				<button>Login</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>