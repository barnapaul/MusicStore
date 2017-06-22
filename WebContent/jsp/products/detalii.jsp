<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
<title>Product Details</title>
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
color:orange;
text-decoration: none;
}
</style>

</head>
<body>
<center>
  <br /> <br /> <br /> <b> Product Details </b><br /> <br />  
  <div>
<table>
<tr>
	<td><b>ID</b></td>
	<td><c:out value="${model.product.id}"/></td>
</tr>
<tr>
	<td><b>Name:</b></td>
	<td><c:out value="${model.product.name}"/></td>
</tr>
<tr>
	<td><b>Price:</b></td>
	<td><c:out value="${model.product.price}"/></td>
</tr>
<tr>
	<td><b>Stoc:</b></td>
	<td><c:out value="${model.product.stoc}"/></td>
</tr>
<tr>
	<td><b>Producator:</b></td>
	<td><c:out value="${model.product.producator}"/></td>
</tr>
<tr><td><a class="icon" href="<c:url value="/products.htm"/>"><i class="icon-arrow-left"></i></a></td></tr>
</table>

</div>
</center>
</body>
</html>