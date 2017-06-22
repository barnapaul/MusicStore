<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
 pageEncoding="ISO-8859-1"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>  
<head>  
<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
<title>Products List</title>  
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
 font-weigh:bold;
}  
a{
text-decoration:none;
}
.icon-info{
color:blue;
}
.icon-pencil{
color:green;
}
.icon-trash{
color:red;
}
.icon-plus{
color:black;}

</style>  
</head>  
<body>  
 <center>  
  <br /> <br /> <br /> <b>Products List </b><br /> <br />  
     
    
  
  <table border="1">  
   <tr>  
    <td class="heading">ID</td>  
    <td class="heading">Name</td>  
    <td class="heading">Price</td>  
    <td class="heading">Stoc</td>  
    <td class="heading">Producator</td> 
    <td class="heading">Details</td>  
    <td class="heading">Edit</td>  
    <td class="heading">Delete</td>  
   </tr>  
   <c:forEach var="p" items="${model['productsList']}">  
    <tr>  
   
	   		<td><c:out value="${p.id}"/></td>
	   		<td><c:out value="${p.name}"/></td>
	   		<td><c:out value="${p.price}"/></td> 
	   		<td><c:out value="${p.stoc}"/></td>
	   		<td><c:out value="${p.producator}"/></td>
	   		<td><a href="<c:url value="/products/detalii/${p.id}"/>"><i class="icon-info"></i></a></td>
	   		<td><a href="<c:url value="/products/editeaza/${p.id}"/>"><i class="icon-pencil"></i></a></td>
	   		<td><a href="<c:url value="/products/delete/${p.id}"/>"></a><i class="icon-trash"></i></td>
    </tr>  
   </c:forEach>  
   <tr><td colspan="8"><a href="<c:url value="/products/adauga"/>"><i class="icon-plus"></i></a></td></tr>  
  </table>  
  
 </center>  
</body>  
</html>  