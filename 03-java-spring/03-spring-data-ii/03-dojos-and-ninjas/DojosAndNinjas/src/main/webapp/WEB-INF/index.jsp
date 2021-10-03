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
    <title>Dojos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<table class="table table-striped table-dark">
		<thead>
			<tr>
				<th>Name</th>
				<th>Show</th>
			</tr>
			<c:forEach items="${allDojos}" var="dojo">
			<tr>
				<td>${language.Name}</td>
				<td><a href="/dojos/${dojo.id}">View Dojo</a></td>
			</tr>
		</c:forEach>
		</thead>
	</table>
</div>
</body>
</html>

