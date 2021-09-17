<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Time</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/time.js"></script>
<%
  SimpleDateFormat time = new SimpleDateFormat("hh:mm");
  String currentTime = time.format(new Date());
%>
</head>
<body>
<div class=main>
<p class="time"><%=currentTime%> PM</p>
</div>
</body>
</html>