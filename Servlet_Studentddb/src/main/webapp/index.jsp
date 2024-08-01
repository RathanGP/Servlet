<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <!--Directive tag--> 
 <%@include file="home.jsp" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--Declarative tag-->
	<%!int a = 10;
	String name = "Rathan";
	String[] names = { "Sam", "Ram", "Ravan" };%>
	
	<!--Expression tag-->
	<h2><%=a%></h2>
	<h2><%=name%></h2>
	
	<!--Scriptlet tag-->
	<%
	for (String n : names) {
	%>
	<h3><%=n%></h3>
	<%
	}
	%>
</body>
</html>