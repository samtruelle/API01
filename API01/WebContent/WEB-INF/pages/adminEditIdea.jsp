<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create a new idea (admin)</title>
</head> 
<body>
	<%@include file="/WEB-INF/pages/navbar.jsp"%>
	<div id="siteContent">
		<div id="warning">
			${message}<br/>	
		</div>
		<form:form role="form" method="POST" modelAttribut="command">
		<div class="form-group" hidden>
				<form:label path="idea_id"></form:label> <form:input type="text"
				class="form-control" path="idea_id"/>
			</div>			
			<div class="form-group" hidden>
				<form:label path="fund"></form:label> <form:input type="text"
					class="form-control" id="fund"
					required="true" path="fund"/>
			</div>
			<div class="form-group" hidden>
				<form:label path="long_summary"></form:label> <form:input type="text"
					class="form-control" id="long_summary"
					path="long_summary"/>
			</div>
			<div class="form-group" hidden>
				<form:label path="state"></form:label> <form:input type="text"
					class="form-control" id="state"
					required="true" path="state"/>
			</div>						
			<div class="form-group">
				<form:label path="description">description:</form:label>
				<form:textarea class="form-control" id="description"
				placeholder="Brief description" required="true" path="description"></form:textarea>
			</div>
			<div class="form-group">
				<form:label path="application">Application:</form:label> <form:input type="text"
				class="form-control" id="application" placeholder="application"
					required="true" path="application"/>
			</div>
			<div class="form-group">
				<form:label path="targeted_market">Targeted market:</form:label> <form:input type="text"
					class="form-control" id="targeted_market" placeholder="Targeted market"
					required="true" path="targeted_market"/>
			</div>			
			<button type="submit" class="btn btn-success">Submit</button>
		</form:form>
	</div>
</body>
</html>