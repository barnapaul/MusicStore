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
 		<th>Id</th>
 		<th>FirstName</th>
 		<th>LastName</th>
   		<th>Email</th>
 
  	</tr>
  	<c:forEach var="u" items="${model['usersList']}">
		<tr>
			<td><c:out value="${u.id}"/></td>
	   		<td><c:out value="${u.fname}"/></td>
	   		<td><c:out value="${u.lname}"/></td>
	   		<td><c:out value="${u.email}"/></td> 
	   		<td><a href="<c:url value="/users/detalii/${u.id}"/>">Details</a></td>
	   		<td><a href="<c:url value="/users/editeaza/${u.id}"/>">Edit</a></td>
	   		<td><a href="<c:url value="/users/delete/${u.id}"/>">Delete</a></td>
		</tr>
	</c:forEach>
</table>

<a href="<c:url value="/users/adauga"/>">Add User</a>

</body>
</html>