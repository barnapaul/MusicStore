<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
<title>Order Details</title>
<style>
body {  
 font-size: 20px;  
 color: teal;  
 font-family: Calibri;  
}  
  
td {  
 font-size: 15px;  
 color: black;  
 width: 100px;  
 height: 22px;  
 text-align: center;  
}  
  
.heading {  
 font-size: 18px;  
 color: white;  
 font: bold;  
 background-color: orange;  
 border: thick;  
}
.icon{
color: orange;
text-decoration:none;
}  
</style>

</head>
<body>
<center>
  <br /> <br /> <br /> <b> Order Details </b><br /> <br />  
  <div>
<table>
<tr>
	<td><b>ID</b></td>
	<td><c:out value="${model.order.id}"/></td>
</tr>
<tr>
	<td><b>UserId:</b></td>
	<td><c:out value="${model.order.userId}"/></td>
</tr>
<tr>
	<td><b>ProductId:</b></td>
	<td><c:out value="${model.order.productId}"/></td>
</tr>
<tr>
	<td><b>OrderDate:</b></td>
	<td><c:out value="${model.order.orderDate}"/></td>
</tr>
<tr>
	<td><b>Quantity:</b></td>
	<td><c:out value="${model.order.quant}"/></td>
</tr>



<tr>
<td colspan="2"><a class="icon" href="<c:url value="/orders.htm"/>"><i class="icon-arrow-left"></i></a></td>
</tr>
</table>

</div>
</center>
</body>
</html>