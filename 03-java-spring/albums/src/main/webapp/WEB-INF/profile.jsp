<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "t" tagdir = "/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<title>User Profile</title>
</head>
<body>
 <!-- begin tag insert --> 
<t:wrapper>
<h1>Details for ${user.firstName} ${user.lastName}</h1>
<hr>
<h2>Albums Added</h2>
<ul>
<c:forEach items="${user.myAlbums}" var="album">
<li><a href="/details/${album.id}">${album.bandName} - ${album.albumName}</a>
</c:forEach>
</ul>
 <!-- end tag insert --> 
</t:wrapper>
</body>
</html>