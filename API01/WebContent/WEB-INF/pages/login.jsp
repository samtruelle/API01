<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View account</title>
<link href="resources/css/app.css" rel="stylesheet" type="text/css"/> 
</head>
<body>
	<%@include file="/WEB-INF/pages/navbar.jsp" %>	
	<div id="siteContent">
		<div id="warning">
			${message}<br/>	
		</div>		
		<form method="POST">
			<div class="form-group">
				<label for="email">Email:</label> 
				<input type="text"
					class="form-control" required="true"
					placeholder="Your email"
					name="email"/>
				<label for="telephone">Password:</label> 
				<input type="password"
					class="form-control" required="true"
					placeholder="Your password"
					name="password"/>
			</div>
			<button type="submit" class="btn btn-success">Submit</button>
		</form>
	</div>
</body>
</html>