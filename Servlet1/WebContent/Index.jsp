<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Location de voiture</title>
</head>
<body><form action='Servlet1' method='POST' name='form1'>Marque de voiture recherchée <input name='1' type='text' value=<% out.println(request.getAttribute("Placeholder"));%>>
<button type='Submit' name='Submit' value='Submit'>Submit</button>
</form></body>
</html>