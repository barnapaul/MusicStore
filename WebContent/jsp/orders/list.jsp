<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order</title>
</head>
<body>
	<table border=1>
		<tr>
			<td>Id<td>
			<td>UserId<td>
			<td>OrderDate<td>
		<tr>
		<c:forEach var="u" items="${model['ordersList']}">
			<tr>
				<td><c:out value="${u.id }"></c:out><td>
				<td><c:out value="${u.userId }"></c:out><td>
				<td><c:out value="${u.orderDate }"></c:out><td>
				<td><a href="<c:url value="/orders/detalii/${u.id}"/>">Details</a></td>
	   			<td><a href="<c:url value="/orders/editeaza/${u.id}"/>">Edit</a></td>
	   			<td><a href="<c:url value="/orders/delete/${u.id}"/>">Delete</a></td>	  
			<tr>
		</c:forEach>
	</table>
<a href="<c:url value="/orders/adauga"/>">Add User</a>	
</body>
</html>