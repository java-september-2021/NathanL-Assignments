<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Welcome To Records dot Com</title>
</head>
<body>
<div class="container">
<h1>Welcome To Records dot Com</h1>
<hr>
<a href="/new">Add An Album</a> 
<table class="table table-striped table-dark">
<thead>
<tr>
<th>Id</th>
<th>Album Name</th>
<th>Band Name</th>
<th>Year</th>
</tr>
<c:forEach items="${allAlbums}" var="album">
<tr>
<td>${album.id}</td>
<td>${album.albumName}</td>
<td>${album.bandName}</td>
<td>${album.year}</td>
</tr>
</c:forEach>


</thead>

</table>

</div>
</body>
</html>