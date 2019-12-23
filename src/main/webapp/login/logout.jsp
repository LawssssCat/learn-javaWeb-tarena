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
		session.setAttribute("username", null) ; 
	%>
	<h3>注销成功！</h3>
	<a href="list.jsp">RETURN</a>
</body>
</html>