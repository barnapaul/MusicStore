<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
<title>User Details</title>
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
text-decoration:none;
color:orange;
}

</style>

</head>
<body>
<center>
  <br /> <br /> <br /> <b> User Details </b><br /> <br />  
  <div>
<table>
<tr>
	<td><b>ID</b></td>
	<td><c:out value="${model.user.id}"/></td>
</tr>
<tr>
	<td><b>FirstName:</b></td>
	<td><c:out value="${model.user.fname}"/></td>
</tr>
<tr>
	<td><b>LastName:</b></td>
	<td><c:out value="${model.user.lname}"/></td>
</tr>
<tr>
	<td><b>Email:</b></td>
	<td><c:out value="${model.user.email}"/></td>
</tr>
<tr>
	<td><b>Telephone:</b></td>
	<td><c:out value="${model.user.telefon}"/></td>
</tr>
<tr>
	<td><b>Address:</b></td>
	<td><c:out value="${model.user.address}"/></td>
</tr>
<tr>
	<td><b>City:</b></td>
	<td><c:out value="${model.user.city}"/></td>
</tr>



<tr>
<td colspan="2"><a class="icon" href="<c:url value="/users.htm"/>"><i class="icon-arrow-left"></i></a></td>
</tr>
</table>

</div>
</center>
</body>
</html>