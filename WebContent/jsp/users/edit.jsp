<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/users/save" method="post" commandName="userForm">
       
<table>
<tr>
	<td>ID</td>
	<td><form:input path="id" readonly="true"/></td>
</tr>
<tr>
	<td>FirstName</td>
	<td><form:input path="fname" /></td>
</tr>
<tr>
	<td>LastName</td>
	<td><form:input path="lname" /></td>
</tr>
<tr>
	<td>Email</td>
	<td><form:input path="email" /></td>
</tr>
<tr>
<td><a href="<c:url value="/users.htm"/>">Back to the list</a></td>
<td><input type=submit value="Save"/></td>
</tr>
</table>
</form:form>
</body>
</html>