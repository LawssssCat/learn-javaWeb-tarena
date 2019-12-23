<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!-- 设置编码 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title></title>
</head>
<body>
<!-- 开始光标位置 -->
	<h3>Hello Filter Test ....</h3>
	<a href="listener/sessionInvalidate.jsp">/listener/sessionInvalidate.jsp</a>
	
	<hr>
	<form action="addSession.jsp" method="post">
		msg:<input type="text" name="msg"><br>
		<input type="submit" value="add into Session">
	</form>
	<hr>
	session.smg:${sessionScope.msg }<br>
</body>
</html>