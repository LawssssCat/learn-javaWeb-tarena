<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>session_invalidate ... </h3>
	<%
		session.invalidate();
		out.println("session has been invalidated ..  ");
	%>
</body>
</html>