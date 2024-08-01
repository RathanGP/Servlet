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
	<%
	ResultSet rs = (ResultSet) request.getAttribute("resultset");
	rs.next();
	%>
	<h1>Update Mobile Details</h1>

	<form action="saveUpdateMobile" method="post">
		<input type="number" placeholder="Enter the MobileId" value="<%=rs.getInt(1)%>" name="mobileid" readonly="readonly"><br> 
		<input type="text" placeholder="Enter the MobileModel" value="<%=rs.getString(2)%>" name="mobilemodel"><br> 
		<input type="text" placeholder="Enter the MobileBrand" value="<%=rs.getString(3)%>" name="mobilebrand"><br> 
		<input type="number" placeholder="Enter the MobilePrice"value="<%=rs.getInt(4)%>" name="mobileprice"><br> 
		<input type="submit" value="UPDATE">
	</form>

</body>
</html>