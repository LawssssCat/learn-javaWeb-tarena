<%@page import="java.util.Date"%>
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
<!-- JSP表达式：里面可以存放 表达式、常量、变量  -->
<%=123+100 %>
<%= new Date() %>
<%="Hello JSP" %>
Hello JSP

<% String str = "韩少云"; %>
<%=str %>
</body>
</html>