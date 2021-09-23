<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<title>The Code index</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
	<div class=main>
		<p class ="error"> ${ errors } </p>
		<h1>What is the code?</h1>
		<form method="POST" action="/data">
	    <input type="text" name="userCode">
	    <button>Submit</button>
		</form>
	</div>
</body>
</head>
