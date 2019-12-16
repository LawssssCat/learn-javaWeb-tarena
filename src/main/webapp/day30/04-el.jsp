<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	request:${pageContext.request }<br>
	<h4>在jsp页面动态获取虚拟目录</h4>
	servletPath:${pageContext.request.servletPath } <br>
	contextPath:${pageContext.request.contextPath }
</body>
</html>