<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页 \(^o^)/~</title>
</head>
<body>
	---- 动态获取虚拟目录：\${pageContext.request.contextPath}/HomeWork1 -----------<br>
	<form action="${pageContext.request.contextPath}/HomeWork1">
		用户名：<input name="user" placeholder="用户名">
		爱好：<input name="like" type="checkbox" value="篮球">篮球
		<input name="like" type="checkbox" value="足球">足球
		<input type="submit" value="提交">
	</form>
	<hr>
	---  发送:HomeWork1   ----------<br>
	<form action="HomeWork1">
		用户名：<input name="user" placeholder="用户名">
		爱好：<input name="like" type="checkbox" value="篮球">篮球
		<input name="like" type="checkbox" value="足球">足球
		<input type="submit" value="提交">
	</form>
	<hr>
	---  发送:/HomeWork1 (失败)如果不在ROOT根目录的话  ----------<br>
	原因：“/” 表示ip(根)目录<br>
	<form action="/HomeWork1">
		用户名：<input name="user" placeholder="用户名">
		爱好：<input name="like" type="checkbox" value="篮球">篮球
		<input name="like" type="checkbox" value="足球">足球
		<input type="submit" value="提交">
	</form>
</body>
</html>