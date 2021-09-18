<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counter</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/date.js"></script>
</head>
<body>
	<div class=main>
	<h1>Welcome User!</h1>
	<p> Go to counter page <a href="http://localhost:8080/counter">http://localhost:8080/counter</a>
	<p>	
	<button onclick="deleteSession()">Clear Session</button>
	</p>
	</div>
</body>
</html>