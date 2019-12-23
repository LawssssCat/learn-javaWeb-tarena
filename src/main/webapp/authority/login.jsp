<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<font color="red" size="20px">${requestScope.msg }</font>
	<hr>
	<form action="${pageContext.request.contextPath }/UserServlet?method=Login" method="post">
		username:<input type="text" name="username" value="${param.username }"><br>
		<input type="submit" value="submit">
	</form>

	<c:if test="${empty sessionScope.user }">
		<hr>
		登陆失败：...
	</c:if>
	<hr>
	<a href="${pageContext.request.contextPath}/authority/list.jsp">RETURN </a>
</body>
</html>