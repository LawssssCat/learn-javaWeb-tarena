<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!-- 设置编码 -->
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title></title>
</head>
<body>
<!-- 开始光标位置 -->
<h3>持久保存 session</h3>
<form action="${pageContext.request.contextPath}/SessionLonger" method="get">
	<input type="text" name="msg" >
	<input type="submit" value="更新msg .." >
</form>

<hr>
msg:${msg } <br>
---<br>
<c:if test="${not empty msg }">
Hi！ -- 关闭浏览器，再打开这地址试试~~  O(∩_∩)O~~
</c:if>
</body>
</html>