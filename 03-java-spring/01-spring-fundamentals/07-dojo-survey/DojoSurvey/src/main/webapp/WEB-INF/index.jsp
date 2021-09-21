<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Survey</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class=main>
		<form method="POST" action="/data">
	    <label>Your Name: 
	    <input type="text" name="username">
	    </label>
	    <br>
	   	<label for="dojo">Dojo Location:</label>
	   	<select id="dojo" name="dojo">
	   		<option value="Burbank">Burbank</option>
	     	<option value="San Jose">San jose</option>
	     	<option value="Other">Other</option>
	   	</select>
	   	<br>
	   	<label for="language">Favorite Language:</label>
	   	<select id="language" name="language">
	     	<option value="Python">Python</option>
	     	<option value="Java">Java</option>
	     	<option value="JS">JS</option>
	   	</select>
	   	<br>
	   	<label for="Comment">Comment (optional):</label>
	   	<br>
	     	<textarea name="comment" rows="10" cols="30"></textarea>
	     <br>
	    <button>Submit</button>
	</form>
	</div>
</body>
</html>