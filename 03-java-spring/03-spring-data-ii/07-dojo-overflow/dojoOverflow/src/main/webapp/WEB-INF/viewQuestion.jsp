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
    <title>View question</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<main>
		 <div class="text-center">
		 	<h1><c:out value="${question.questionText}"/></h1>
		 	<a href="/dashboard">Dashboard</a> 
	 	</div>
	 	<div class="container">
			<p>Tags:</p>
			<ul> 
	        	<c:forEach items="${question.tags}" var="tag">
	            	<li class="list-group-item d-inline"><c:out value="${tag.subject}"/></li>
	        	</c:forEach>
		    </ul>	
				<table>
			    	<thead>
			        	<tr>
			            	<th>Answers</th>
			       		</tr>
			    	</thead>
			    	<tbody>
			        	<c:forEach items="${question.answers}" var="answer">
			        	<tr>
			            	<td><c:out value="${answer.answerText}"/></td>
			        	</tr>
			        	</c:forEach>
			    	</tbody>
				</table>
				<form:form action="/questions/addAnswer" method="POST" modelAttribute="answer"> 
				    <form:input type="hidden" path="question" value="${ question.id }"/>
			        <div class="form-group row">
				        	<form:label path="answerText"> Answer:</form:label>
				        	<form:textarea type="text" path="answerText"/>
		        			<form:errors path="answerText"/>
			        </div>
					<div>
					    <div>
					    	<input class = "btn btn-success" type="submit" value="Add"/>
				    	</div>
			    	</div>
				</form:form>
			</div>
	</main>
</body>
</html>
