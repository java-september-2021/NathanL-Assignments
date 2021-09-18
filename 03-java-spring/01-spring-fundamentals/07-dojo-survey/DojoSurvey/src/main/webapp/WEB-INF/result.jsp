<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counter</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class=main>
	<h1>Submitted Info</h1>
	<p>
	Name: ${ username }
	<br>
	Dojo Location: ${ dojo }
	<br>
	Favorite Language: ${ language }
	<br>
	Comment: ${ comment }
	
	</p>
	</div>
</body>
</html>