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
    <title>New question</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<main>
		<div class="text-center">
	 		<h1>What is your question?</h1>
	 		<a href="/dashboard">Dashboard</a> 
			<form:form action="/questions/new" method="POST" modelAttribute="question">
			    <div class="container"">
			        <form:label path="questionText">Question</form:label>
			        <div>
			        	<form:textarea type="text" path="questionText"/>
			        	<form:errors  path="questionText"/>
			        </div>
			    </div>
			    <div>
			        <form:label path="parsedTags">Tags</form:label>
			     	<form:input type="text" path="parsedTags"/>
			        <form:errors path="parsedTags"/>
			    	<input class = "btn btn-success" type="submit" value="Submit"/>	
			    </div>
			</form:form>
		</div>
	</main>
</body>
</html>
