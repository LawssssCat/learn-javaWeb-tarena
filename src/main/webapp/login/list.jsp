<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!-- 设置编码 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title></title>
<style type="text/css">
font {
	color: red;
	font-size: 20px;
}
</style>

</head>
<body>


	<b>欢迎！ ~~~ ${sessionScope.username }</b> <br>
<!-- 开始光标位置 -->
	<a href="a.jsp">AAA</a><br><br>
	<a href="b.jsp">BBB</a><font>（付费阅读）</font>  <br><br>
	<a href="c.jsp">CCC</a><font >（付费阅读）</font>  <br><br>
	<a href="d.jsp">DDD</a><font >（付费阅读）</font>  <br><br>
	<a href="e.jsp">EEE</a><font>（付费阅读）</font>  <br><br>
	<hr>
	<a href="logout.jsp">注销</a>  <br><br>
	
</body>
</html>