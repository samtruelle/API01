<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>Home</title>
</head>
<body>
	<%@include file="/WEB-INF/pages/navbar.jsp" %>	
	<div id="warning">
		${message}<br/>	
	</div>		
	<c:if test="${sessionScope=='{}'}">
		Welcome to the API01 project, you are not logged ->
		<a href="login.htm" class="btn btn-primary">login</a>
		Or create an account ->
		<a href="register.htm" class="btn btn-primary">register</a>
	</c:if>
	<c:if test="${sessionScope.admin==0}">
		See the last ideas proposed
		<a href="Ideas" class="btn btn-primary">Check new ideas</a>
		You have a good idea ? Share it with people to fund it !
		<a href="userCreateIdea" class="btn btn-primary">Create an ideas</a>
		
		See the evolutions of your ideas.
		<a href="userIdeas" class="btn btn-primary">See my ideas</a>
		
		See the evolutions of the the ideas that you discussed on.
		<a href="userCommentedIdeas" class="btn btn-primary">See the ideas</a>
	</c:if>
	<c:if test="${sessionScope.admin != 0}">
		<a href="adminUsers" class="btn btn-primary">Users</a>
		<a href="adminIdeas" class="btn btn-primary">Idea</a>
		<a href="adminComments" class="btn btn-primary">Comment</a>
	</c:if>
	
</body>
</html>