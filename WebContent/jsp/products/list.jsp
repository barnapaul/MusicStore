<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<tr>
			<th>ID<th>
			<th>Name<th>
			<th>Price<th>
			<th>Stoc<th>
			<th>Producator<th>
		<tr>
		<c:forEach var="u" items="${model['productsList']}">
			<tr>
				<td><c:out value="${u.id}"></c:out><td>
				<td><c:out value="${u.name}"></c:out><td>
				<td><c:out value="${u.price}"></c:out><td>
				<td><c:out value="${u.stoc}"></c:out><td>	
				<td><c:out value="${u.producator}"></c:out></td>	
				<td><a href="<c:url value="/products/detalii/${u.id}"/>">Details</a></td>
	   			<td><a href="<c:url value="/products/editeaza/${u.id}"/>">Edit</a></td>
	   			<td><a href="<c:url value="/products/delete/${u.id}"/>">Delete</a></td>	
				<tr>	
		 </c:forEach>	
	 </table>
	 
<a href="<c:url value="/products/adauga"/>">Add User</a>	 
</body>
</html>