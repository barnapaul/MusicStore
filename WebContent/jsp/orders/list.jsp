<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
<title>Orders List</title>
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
 font-weight:bold;
}  
a{
color: black;
text-decoration: none;
font-family: monospace; 	
}
.icon-trash{
color: red;
}
.icon-info{
color: blue;
}
.icon-pencil{
color:green;
}
</style>

</head>
<body>
<center>
 <br /> <br /> <br /> <b>Orders List </b> <br />  
  <br />
<table border=1>
	<tr>
 		<td class="heading">ID</td>
 		<td class="heading">UserId</td>
 		<td class="heading">ProductId</td>
   		<td class="heading">OrderDate</td>
   		<td class="heading">Quantity</td>
   		<td class="heading">Details</td>
   		<td class="heading">Edit</td>
   		<td class="heading">Delete</td>
 
  	</tr>
  	<c:forEach var="o" items="${model['ordersList']}">
		<tr>
			<td><c:out value="${o.id}"/></td>
	   		<td><c:out value="${o.userId}"/></td>
	   		<td><c:out value="${o.productId}"/></td>
	   		<td><c:out value="${o.orderDate}"/></td> 
	   		<td><c:out value="${o.quant}"/></td> 
	   		<td><a href="<c:url value="/orders/detalii/${o.id}"/>"><i class="icon-info"></i></a></td>
	   		<td><a href="<c:url value="/orders/editeaza/${o.id}"/>"><i class="icon-pencil"></i></a></td>
	   		<td><a href="<c:url value="/orders/delete/${o.id}"/>"><i class="icon-trash"></i></a></td>
		</tr>
		
	</c:forEach>
	<tr><td colspan="8"><a href="<c:url value="/orders/adauga"/>"><i class="icon-plus"></i></a></td></tr>
</table>


</center>
</body>
</html>