<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
<title>Users List</title>
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
 font-weight: bold; 
}  
a{
color: black;
text-decoration: none;
font-family: monospace; 	
}
.delete{
color: red;
}
.details{
color: blue;
}
.edit{
color:green;
}


</style>

</head>
<body>
<center>
 <br /> <br /> <br /> <b>Users List </b> <br />  
  <br />
<table border=1>
	<tr>
 		<td class="heading">ID</td>
 		<td class="heading">FirstName</td>
 		<td class="heading">LastName</td>
   		<td class="heading">Email</td>
   		<td class="heading">Telephone</td>
   		<td class="heading">Address</td>
   		<td class="heading">City</td>
   		<td class="heading">Details</td>
   		<td class="heading">Edit</td>
   		<td class="heading">Delete</td>
 
  	</tr>
  	<c:forEach var="u" items="${model['usersList']}">
		<tr>
			<td><c:out value="${u.id}"/></td>
	   		<td><c:out value="${u.fname}"/></td>
	   		<td><c:out value="${u.lname}"/></td>
	   		<td><c:out value="${u.email}"/></td> 
	   		<td><c:out value="${u.telefon}"/></td> 
	   		<td><c:out value="${u.address}"/></td> 
	   		<td><c:out value="${u.city}"/></td> 
	   		<td><a class="details" href="<c:url value="/users/detalii/${u.id}"/>"><i class="icon-info"></i></a></td>
	   		<td><a class="edit" href="<c:url value="/users/editeaza/${u.id}"/>"><i class="icon-pencil"></i></a></td>
	   		<td><a class="delete" href="<c:url value="/users/delete/${u.id}"/>"><i class="icon-trash"></i></a></td>
		</tr>
		
	</c:forEach>
	<tr><td colspan="10"><a href="<c:url value="/users/adauga"/>"><i class="icon-plus"></i></a></td></tr>
</table>


</center>
</body>
</html>