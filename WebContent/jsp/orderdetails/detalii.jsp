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
<table>
<tr>
	<td>ID</td>
	<td><c:out value="${model.orderdetail.id}"/></td>
</tr>
<tr>
	<td>OrderId</td>
	<td><c:out value="${model.orderdetail.orderId}"/></td>
</tr>
<tr>
	<td>ProductId</td>
	<td><c:out value="${model.orderdetail.productId}"/></td>
</tr>
<tr>
	<td>Quantity</td>
	<td><c:out value="${model.orderdetail.quant}"/></td>
</tr>
</table>
<a href="<c:url value="/orderdetails.htm"/>">Back to the list</a>
</body>
</html>