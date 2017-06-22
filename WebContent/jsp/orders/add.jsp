<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
<title>Add Order</title>
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
 text-align: left;  
}  
  
.heading {  
 font-size: 18px;  
 color: white;  
 font: bold;  
 background-color: orange;  
 border: thick;  
}  
input:hover{
background-color: #D3D3D3;
}
.save:hover{
background-color: #87CEFA;
}
.icon{
color:orange;
text-decoration: none;
}
</style>
</head>
<body>
<center>
 <br /> <br /> <br /> <b>Add Order </b> <br />  
  <br />
  <div>
<form:form action="${pageContext.request.contextPath}/orders/addOrder" method="post" commandName="orderForm">
       
<table>
<tr>
	<td><b>UserId:</b></td>
	<td><form:input path="userId" /></td>
</tr>
<tr>
	<td><b>ProductId:</b></td>
	<td><form:input path="productId" /></td>
</tr>
<tr>
	<td><b>OrderDate:</b></td>
	<td><form:input path="orderDate" /></td>
</tr>
<tr>
	<td><b>Quantity:</b></td>
	<td><form:input path="quant" /></td>
</tr>

<tr>
<td></td>
<td  ><input class="save" type=submit value="Save"/></td>
</tr>
<tr>
<td colspan="2" ><a class="icon" href="<c:url value="/orders.htm"/>"><i class="icon-arrow-left"></i></a></td>

</tr>
</table>
</form:form>
</div>  
</center>
</body>
</html>