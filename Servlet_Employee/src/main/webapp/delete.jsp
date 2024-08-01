<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% ResultSet rs=(ResultSet) request.getAttribute("resultset"); %>

<h1>Deletion Operation..!</h1>
<form action="deleteRecord" method="post">
<input type="number" placeholder="Enter EmployeeId" name="employeeId"><br>
<input type="submit" value="DELETE"> 
</form>

</body>
</html>