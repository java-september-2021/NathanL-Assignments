<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Album</title>
</head>
<body>
<div class="container">
	<a href="/languages">Dashboard </a> 
	<form action="/languages/${language.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
	</form>
<form:form method="POST" action="/languages/${language.id}/edit" modelAttribute="language">
	<form:label path="name">Name</form:label>
	<form:errors path="name"/>
	<form:input type="text" value="${language.name}" path="name"/>
	<form:label path="creator">Creator</form:label>
	<form:errors path="creator"/>
	<form:input type="text" value="${language.creator}" path="creator"/>
	<form:label path="version">Version</form:label>
	<form:errors path="version"/>
	<form:input type="text" value="${language.version}" path="version"/>
	<p><button>Edit Album</button>
</form:form>
</div>
</body>
</html>