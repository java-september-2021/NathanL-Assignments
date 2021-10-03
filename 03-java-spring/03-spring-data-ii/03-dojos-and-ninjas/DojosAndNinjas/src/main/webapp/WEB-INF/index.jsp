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
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<main>
		<div class="text-center">
	 		<h1>All Dojos</h1>
	 		<a href="/dojos/new">New Dojo</a> | <a href="/ninjas/new">New Ninja</a> 
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
		        	<c:forEach items="${allDojos}" var="dojo">
		        	<tr>
		            	<td><c:out value="${dojo.name}"/></td>
		            	<td> 
		            		<a href="/dojos/${dojo.id}">Show</a>
		            	</td>
		        	</tr>
		        	</c:forEach>
			    </tbody>
			</table>
		</div>
	</main>
</body>
</html>

