<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Form </title>
<style type="text/css">

.tab2{
	border-style: solid;
	border-width: thin;
	width: auto;
	height:8em;
}
.td12{
	border-style: solid;
	border-width: thin;
	padding-left: 5px;
	padding-right: 5px;
}

 .inp{margin-top: 10px;
  background-color: green;
  color: white ;
  border-width: 0px;
  border-radius: 3px;
  height: 30px;
}

.inp1{
width:220px;
height:22px;


}



</style>
</head>
<body>
	<div align="center">
	<c:if test="${um==null}">
		<h1>Add New User</h1>
	</c:if>
	<c:if test="${um!=null}">
		<h1>Edit User</h1>
	</c:if>
	
	<c:if test="${um==null}">
	<form action="add" method="post">
	</c:if>
	<c:if test="${um!=null}">
	<form action="modify" method="post">
	</c:if>
			<input type="hidden" name="id" value="${um.id}">
	<table class="tab2">
		<tr>
			<td class="td12">Enter name :</td>
			<td class="td12"><input class="inp1" type="text" name="name" value="${um.name}"></td>
		</tr>
		<tr>
			<td class="td12">Enter Email :</td>
			<td class="td12"><input class="inp1" type="text" name="email" value="${um.email}"></input></td>
		</tr>
		<tr>
			<td class="td12">Enter Country :</td>
			<td class="td12"><input class="inp1" type="text" name="country" value="${um.country}"></input></td>
		</tr>
	</table>
	<input type="submit" value="submit" class="inp">
	</form>
	</div>
</body>
</html>