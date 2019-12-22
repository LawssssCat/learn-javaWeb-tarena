<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${sessionScope.user=null }
	<h3>用户登出成功...</h3>
	<hr>
	<a href="${pageContext.request.contextPath}/authority/list.jsp">RETURN </a>
</body>
</html>