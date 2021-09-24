<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Language view</title>
</head>
<body>
	<div class="container">
		<a href="/languages">Dashboard </a> 
		<hr>
		<p>
			Name:
			${language.name}
			<br>
			Creator:
			${language.creator}
			<br>
			Version:
			${language.version}
		</p>
		<a href="/languages/${language.id}/edit">Edit </a> 
		<br>
		<form action="/languages/${language.id}" method="post">
	    <input type="hidden" name="_method" value="delete">
	    <input type="submit" value="Delete">
		</form>
	</div>
</body>
</html>