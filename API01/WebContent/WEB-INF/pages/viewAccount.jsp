<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View account</title>
</head>
<body>
	<%@include file="/WEB-INF/pages/navbar.jsp" %>
	<div id="siteContent">
		<div id="UserCard">
			<div class="item">
				<label>Account :</label>
				<span>${user.email}</span>
			</div>
			<div class="item">
				<label>First Name :</label>
				<span>${user.firstName}</span>
			</div>
			<div class="item">
				<label>Last Name :</label>
				<span>${user.lastName}</span>
			</div>
			<div class="item">
				<label>Adress :</label>
				<span>${user.adress}</span>
			</div>
			<div class="item">
				<label>Telephone :</label>
				<span>${user.telephone}</span>
			</div>
			<div id="editAccount">				
				<a href="editAccount" class="btn btn-primary">Edit your account</a>
			</div>
			<div id="editMdp">				
				<a href="editPassword" class="btn btn-primary">Edit your password</a>
			</div>			
		</div>
	</div>
</body>
</html>