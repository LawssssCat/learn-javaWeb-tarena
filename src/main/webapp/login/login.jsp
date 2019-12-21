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
		<form action="doLogin.jsp" method="post">
			username:<input type="text" name="username" value="${sessionScope.username }"><br>
			<input type="submit" value="登录">
			
		</form>
</body>
</html>