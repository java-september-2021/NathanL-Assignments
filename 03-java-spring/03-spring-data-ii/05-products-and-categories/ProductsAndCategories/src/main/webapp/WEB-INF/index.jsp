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
    <title>Products and Categories</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<main>
		<div class="text-center">
	 		<h1>All Products</h1>
	 		<a href="/products/new">New Product</a> 
	 	</div>
		<div class="container">
			<table class="table table-striped table-dark">
			<thead>
	        	<tr>
	            	<th>Name</th>
	            	<th>Action</th>
	       		</tr>
    		</thead>
	    		<tbody>
		        	<c:forEach items="${allProducts}" var="product">
		        	<tr>
		            	<td><c:out value="${product.name}"/></td>
		            	<td> 
		            		<a href="/products/${product.id}">Show</a>
		            	</td>
		        	</tr>
		        	</c:forEach>
			    </tbody>
			</table>
		</div>
		
		<div class="text-center">
			<h1>All Categories</h1>
	 		<a href="/categories/new">New Category</a> 
	 	</div>
		<div class="container">
			<table class="table table-striped table-dark">
			<thead>
	        	<tr>
	            	<th>Name</th>
	            	<th>Action</th>
	       		</tr>
    		</thead>
	    		<tbody>
		        	<c:forEach items="${allCategories}" var="category">
		        	<tr>
		            	<td><c:out value="${category.name}"/></td>
		            	<td> 
		            		<a href="/categories/${category.id}">Show</a>
		            	</td>
		        	</tr>
		        	</c:forEach>
			    </tbody>
			</table>
		</div>
	</main>
</body>
</html>
