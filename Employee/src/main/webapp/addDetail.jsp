<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Perform Addition Operation for Employee Details</h1>
	<form action="addDetail" method="post">
		<input type="number" placeholder="Enter EmployeeId" name="employeeId"><br>
		<input type="text" placeholder="Enter EmployeeName"name="employeeName"><br>
		<input type="text" placeholder="Enter EmployeeEmail" name="employeeEmail"><br>
		<input type="number" placeholder="Enter EmployeeSalary"	name="employeeSalary"><br>
		<input type="submit" value="ADD">
	</form>

</body>
</html>