<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

<title>Add an Album</title>
</head>
<body>
<div class="container">
<h1>Create a new Album</h1>
<hr>
<h3>SpringMVC Forms</h3>
<form:form method="POST" action="/new" modelAttribute="album">
	<form:label path="albumName">Album Name</form:label>
	<form:errors path="albumName"/>
	<form:input type="text" path="albumName"/>
	<form:label path="bandName">Band Name</form:label>
	<form:errors path="bandName"/>
	<form:input type="text" path="bandName"/>
	<form:label path="year">Year</form:label>
	<form:errors path="year"/>
	<form:input type="text" path="year"/>
	<p><button>Create Album</button>
</form:form>
<hr>
<h3>HTML Forms Way</h3>
<form action="/htmladd" METHOD="POST">
<p>Album Name:</p>
<input name="albumName" type="text">
<p>Band Name:</p>
<input name="bandName" type="text">
<p>Release Year:</p>
<input name="year" type="text">
<button>Add Album</button>
</form>
</div>
</body>
</html>