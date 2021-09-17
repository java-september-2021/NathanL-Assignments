<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Date</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/date.js"></script>
<%
  SimpleDateFormat sdfdate = new SimpleDateFormat("dd");
  SimpleDateFormat sdfday = new SimpleDateFormat("EEEE");
  SimpleDateFormat sdfmonth = new SimpleDateFormat("MMMM");
  SimpleDateFormat sdfyear = new SimpleDateFormat("YYYY");
  String date = sdfdate.format(new Date());
  String day = sdfday.format(new Date());
  String month = sdfmonth.format(new Date());
  String year = sdfyear.format(new Date());
%>
</head>
<body>
<div class=main>
	<p class="date"><%=day%>, the <%=date%> of <%=month%>, <%=year%></p>
</div>
</body>
</html>