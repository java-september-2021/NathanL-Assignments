<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Song</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h2>Add A New Song</h2>
<hr>
<form:form method="POST" action="/song/newSong" modelAttribute="song">
	<div class="form-control">
		<form:label path="name">Song Name:</form:label>
		<form:errors path="name"/>
		<form:input type="text" path="name"/>
	</div>
	<div class="form-control">
		<form:label path="length">Song Length:</form:label>
		<form:errors path="length"/>
		<form:input type="text" path="length"/>
	</div>
	
	<form:select path="albumSongIsOn">
	<c:forEach items="${albums}" var="album">
	<option value="${album.id}">${album.bandName} ${album.albumName}</option>
	</c:forEach>	
	</form:select>
	
	<button>Add Song</button>
</form:form>


</div>
</body>
</html>