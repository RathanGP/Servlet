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

<h1>Updation Operation..!</h1>
<form action="updateRecord" method="post">
<input type="number" placeholder="Enter EmployeeId" name="employeeId"><br>
<input type="text" placeholder="Enter EmployeeName" name="employeeName"><br>
<input type="text" placeholder="Enter EmployeeEmail" name="employeeEmail"><br>
<input type="number" placeholder="Enter EmployeeSal" name="employeeSal"><br>
<input type="submit" value="UPDATE"> 
</form>

</body>
</html>