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
	<h3>登录界面</h3>
	<hr>
	
	<form action="hello.jsp" method="post">
		username:<input type="text" name="username" value="${param.username }"> <br>
		password:<input type="password" name="password"> <br>
		<input type="submit"> <font color="red">${message }</font>
	</form>
</body>
</html>