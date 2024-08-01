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

	<table border="">
		<tr>
			<th>EmployeeId</th>
			<th>EmployeeName</th>
			<th>EmployeeEmail</th>
			<th>EmployeeSal</th>
		</tr>
		<% while(rs.next()){ %>
		<tr>
		<td><%=rs.getInt(1) %></td>
		<td><%=rs.getString(2) %></td>
		<td><%=rs.getString(3) %></td>
		<td><%=rs.getInt(4) %></td>
		<td><a href="UpdateEmployee?employeeId=<%=rs.getInt(1)%>">Update</a></td>
		<td><a href="DeleteEmployee?employeeId=<%=rs.getInt(1)%>">Delete</a></td>
		</tr>
		<%} %>
	</table>

</body>
</html>