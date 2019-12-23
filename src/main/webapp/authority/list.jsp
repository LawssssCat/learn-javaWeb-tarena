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
	<c:set var="profix" value="${pageContext.request.contextPath }/authority"/>
	<c:if test="${not empty sessionScope.user }">
		<font size="20px">欢迎！~~~ ${sessionScope.user.name }</font><br>
		<a href="${profix }/loginout.jsp">login out</a><br>	
	</c:if>
	<c:if test="${empty sessionScope.user }">
		<a href="${profix }/login.jsp">请登录</a><br>
	</c:if>
	<hr>
	<a href="${profix }/article-1.jsp">article-1</a><br>
	<a href="${profix }/article-2.jsp">article-2</a><br>
	<a href="${profix }/article-3.jsp">article-3</a><br>
	<a href="${profix }/article-4.jsp">article-4</a><br>
<hr>
	
</body>
</html>