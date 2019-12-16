<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页 ^(*￣(oo)￣)^</title>
</head>
<body>
	<h1>day10...index.jsp...</h1>
	
	<!-- 执行程序，不会直接输出 -->
	<%
		String name = request.getRemoteAddr(); 
		Object port = request.getRemotePort() ; 
		Object user = request.getAttribute("name"); 
		out.print("Remote Info : " + name +":" + port + " --> "+user);
	%>
	
	<!-- 直接输出，但只能一个表达式 -->
	<%="<p>当前时间："+new Date() +"</p>"%>
	
	<%for(int i =0 ; i<5 ; i++) { %>
		Hello JSP <br/>
	<%} %>
	<hr>
	<p>JSP（全称JavaServer Pages）是由Sun Microsystems公司主导创建的一种动态网页技术标准。</p>
</body>
</html>