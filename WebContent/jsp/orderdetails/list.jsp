<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<table border=1>
		<tr>
			<td>Id<td>
			<td>OrderId<td>
			<td>ProductId<td>
			<td>Quantity<td>
		<tr>
		<c:forEach var="u" items="${model['orderdetailsList']}">
			<tr>
				<td><c:out value="${u.id }"></c:out><td>
				<td><c:out value="${u.orderId }"></c:out><td>
				<td><c:out value="${u.productId }"></c:out><td>
				<td><c:out value="${u.quant}"></c:out><td>
				<td><a href="<c:url value="/orderdetails/detalii/${u.id}"/>">Details</a></td>
	   			<td><a href="<c:url value="/orderdetails/editeaza/${u.id}"/>">Edit</a></td>
	   			<td><a href="<c:url value="/orderdetails/delete/${u.id}"/>">Delete</a></td>	
				<tr>
		</c:forEach>
	</table>
	<a href="<c:url value="/orderdetails/adauga"/>">Add User</a>
</body>
</html>