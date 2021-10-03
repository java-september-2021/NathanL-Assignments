<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Ninja</title>
   <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<main>
		<div class="text-center">
	 		<h1>New Ninja</h1>
	 		<a href="/dojos">Dojos</a> 
	 	</div>
		<div class="text-center">
			<form:form method="POST" action="/ninjas/new" modelAttribute="ninja">
				<form:label path="dojo">Dojo:</form:label>
				<form:errors path="dojo"/>
				<form:select path="dojo">
		        	<c:forEach items="${allDojos}" var="dojo">
		        		<form:option value="${dojo.id}">${dojo.name}</form:option>
		        	</c:forEach>
	        	</form:select>
				<form:label path="firstName">First Name:</form:label>
				<form:errors path="firstName"/>
				<form:input type="text" path="firstName"/>
				<form:label path="lastName">Last Name:</form:label>
				<form:errors path="lastName"/>
				<form:input type="text" path="lastName"/>
				<form:label path="age">Age:</form:label>
				<form:errors path="age"/>
				<form:input type="text" path="age"/>
				<p><button>Create</button>
			</form:form>
		</div>
	</main>
</body>
</html>

