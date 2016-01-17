<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/css/main.css"  type="text/css" rel="stylesheet">
<title>Register</title>
</head> 
<body>
	<%@include file="/WEB-INF/pages/navbar.jsp"%>
	<div id="siteContent">
		<form:form role="form" method="POST" modelAttribut="command">
			<div>Thank you for register! Please fill the form below, all the fields are required.</div>
			<div id="warning">
				${message}<br/>	
			</div>
			<div class="form-group">
				<form:label path="email">Email address:</form:label> <form:input type="email"
					class="form-control" id="email"
					placeholder="Fill in your Email adress" required="true" path="email"/>
			</div>
			<div class="form-group">
				<form:label path="password">Password:</form:label> <form:input type="password"
					class="form-control" id="password" placeholder="Fill in your password"
					required="true" path="password"/>
			</div>
			<div class="form-group">
				<form:label path="firstName">First name:</form:label> <form:input type="text"
					class="form-control" id="firstName"
					placeholder="Give us your first name" required="true" path="firstName"/>
			</div>
			<div class="form-group">
				<form:label path="lastName">Last name:</form:label> <form:input type="text"
					class="form-control" id="lastName"
					placeholder="Give us your last name" required="true" path="lastName"/>
			</div>
			<div class="form-group">
				<form:label path="adress">Adress:</form:label>
				<form:textarea class="form-control" id="adress"
					placeholder="Fill in your complete adress" required="true" path="adress"></form:textarea>
			</div>
			<div class="form-group">
				<form:label path="telephone">telephone:</form:label> <form:input type="tel"
					class="form-control" id="telephone" required="true"
					placeholder="Phone number with country number"
					path="telephone"
					pattern="^((\+\d{1,3}(-| )?\(?\d\)?(-| )?\d{1,5})|(\(?\d{2,6}\)?))(-| )?(\d{3,4})(-| )?(\d{4})(( x| ext)\d{1,5}){0,1}$"/>
			</div>
			<button type="submit" class="btn btn-success">Submit</button>
		</form:form>
	</div>
</body>
</html>