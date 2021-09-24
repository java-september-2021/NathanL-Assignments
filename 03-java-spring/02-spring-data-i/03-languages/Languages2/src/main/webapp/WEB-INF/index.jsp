<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Languages</title>
</head>
<body>
<div class="container">
	<table class="table table-striped table-dark">
		<thead>
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${allLanguages}" var="language">
			<tr>
				<td><a href="/languages/${language.id}">${language.name} </a> </td>
				<td>${language.creator}</td>
				<td>${language.version}</td>
				<td> <form action="/languages/${language.id}" method="post">
			    <input type="hidden" name="_method" value="delete">
			    <input type="submit" value="Delete">
				</form> 
				<a href="/languages/${language.id}/edit">Edit </a> 
			</tr>
		</c:forEach>
		</thead>
	</table>
	<form:form method="POST" action="/languages" modelAttribute="language">
		<form:label path="name"> Name</form:label>
		<form:errors path="name"/>
		<form:input type="text" path="name"/>
		<form:label path="creator">Creator</form:label>
		<form:errors path="creator"/>
		<form:input type="text" path="creator"/>
		<form:label path="version">Version</form:label>
		<form:errors path="version"/>
		<form:input type="text" path="version"/>
		<p><button>Create Language</button>
	</form:form>
</div>
</body>
</html>