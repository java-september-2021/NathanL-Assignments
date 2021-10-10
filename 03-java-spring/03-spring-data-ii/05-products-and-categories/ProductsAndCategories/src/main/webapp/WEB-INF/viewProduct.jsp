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
    <title>View Product</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<main>
		<div class="text-center">
	 		<h1><c:out value="${product.name}"/></h1>
	 		<a href="/landing">Dashboard</a> 
	 	</div>
		<div class="container">
			<table class="table table-striped table-dark">
		    	<thead>
		        	<tr>
		            	<th>Categories</th>
		       		</tr>
		    	</thead>
		    	<tbody>
		        	<c:forEach items="${categoriesListed}" var="category">
		        	<tr>
		            	<td><c:out value="${category.name}"/></td>
		        	</tr>
		        	</c:forEach>
		    	</tbody>
			</table>
		</div>
		<div class="text-center">
	 		<h1>Add Category</h1>
	 	</div>
		<div class="text-center">
			<form action="/products/${product.id}" id="categories" method="POST">
			  <input type="submit">
			</form>
			<select name="category" id="category" form="categories">
			<c:forEach items="${categoriesNotListed}" var="category">
		        		<option value="${category.id}">${category.name}</option>
		        	</c:forEach>
			</select>
		</div>
	</main>
</body>
</html>