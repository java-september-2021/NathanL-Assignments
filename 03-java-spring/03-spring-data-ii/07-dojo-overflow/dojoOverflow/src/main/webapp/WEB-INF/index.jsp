<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<main>
	 	<h3>Questions Dashboard</h3>
	 	<a href="/questions/new">New Question</a> 
		<div class="row">
			<div class="col-9">
				<table class="table table-dark table-small mt-3">
			    	<thead>
			        	<tr>
			            	<th>Question</th>
			            	<th>Tags</th>
			            	<th>Action</th>
			       		</tr>
			    	</thead>
			    	<tbody>
			        	<c:forEach items="${questions}" var="question">
			        	<tr>
			            	<td><c:out value="${question.questionText}"/></td>
			            	<td>
			       		        <c:forEach items="${question.tags}" var="tag">
			            			<span>${ tag.subject }<c:if test="${ question.tags.indexOf(tag) != question.tags.size() - 1 }">, </c:if></span>
			            		</c:forEach>
			            	</td>
			            	<td> 
			            		<a href="/questions/${question.id}">Show</a>
			            	</td>
			        	</tr>
			        	</c:forEach>
			    	</tbody>
				</table>
			</div>
		</div>
	</main>
</body>
</html>
