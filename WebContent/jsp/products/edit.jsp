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
<title>Edit Product Details</title>
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
input:hover{
background-color:#D3D3D3
}
.save:hover{
background-color:#87CEFA;
}
</style>

</head>
<body>
<center>
<br /> <br /> <br /> <b>Edit Product Details </b><br /> <br />  
<div>
<form:form action="${pageContext.request.contextPath}/products/save" method="post" commandName="productForm">
       
<table>
<tr>
	<td>ID</td>
	<td><form:input path="id" readonly="true"/></td>
</tr>
<tr>
	<td>Name</td>
	<td><form:input path="name" /></td>
</tr>
<tr>
	<td>Price</td>
	<td><form:input path="price" /></td>
</tr>
<tr>
	<td>Stoc</td>
	<td><form:input path="stoc" /></td>
</tr>
<tr>
	<td>Producator</td>
	<td><form:input path="producator" /></td>
</tr>
<tr>

<td colspan="2"><input class="save" type=submit value="Save"/></td>
	
	</tr>
<tr>
	
	<td ><a class="icon"href="<c:url value="/products.htm"/>"><i class="icon-arrow-left"></i></a></td>
</tr>
</table>
</form:form>
</div>
</center>
</body>
</html>