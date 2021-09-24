<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Album</title>
</head>
<body>
<form:form method="POST" action="/edit/${album.id}" modelAttribute="album">
	<form:label path="albumName">Album Name</form:label>
	<form:errors path="albumName"/>
	<form:input type="text" path="albumName"/>
	<form:label path="bandName">Band Name</form:label>
	<form:errors path="bandName"/>
	<form:input type="text" path="bandName"/>
	<form:label path="year">Year</form:label>
	<form:errors path="year"/>
	<form:input type="text" path="year"/>
	<p><button>Edit Album</button>
</form:form>
</body>
</html>