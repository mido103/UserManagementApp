<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list of users</title>
<style type="text/css">
.tab1{
	border-style: solid;
	border-width: thin;
	width:35%;
}
.t1{
	border-style: solid;
	border-width: thin;
	padding-bottom: 5px;
	padding-top: 5px;
	
}
.c1{
	font-size: 20px;
	font-weight: bold;
	padding-bottom: 15px;

}
.t2{

border-style: solid;
border-width: thin;
text-align: center;

}

</style>

</head>
<body>
		<div align="center">
		<h1>User Management</h1>
		<%session.invalidate();%>
		<h2 style="padding-bottom: 20px;"><a href="<%= request.getContextPath()%>/new">Add New User</a>&nbsp;&nbsp;
		<a href="<%=request.getContextPath()%>/list">List All Users</a></h2>
		<table class="tab1">
			<caption class="c1">List Of Users</caption>
			<thead>
					<th class="t1">ID</th>
					<th class="t1">Name</th>
					<th class="t1">Email</th>
					<th class="t1">Country</th>
					<th class="t1">Actions</th>
			</thead>		
			<tbody>
				<c:forEach var="user" items="${user}">
				<tr>
					<td class="t2"><c:out value="${user.id}"></c:out></td>
					<td class="t2"><c:out value="${user.name}"></c:out></td>
					<td class="t2"><c:out value="${user.email}"></c:out></td>
					<td class="t2"><c:out value="${user.country}"></</c:out></td>
					<td class="t2"><a href="edit?id=<c:out value ="${user.id}"></c:out>">Edit</a> &nbsp;&nbsp;<a href="delete?id=<c:out value ="${user.id}"></c:out>">Delete</a></td>
				</tr>
				</c:forEach>
			
			
			</tbody>
			
			
			
			
			
			
			<tbody></tbody>
		
		
		
		</table>
	</div>



</body>
</html>