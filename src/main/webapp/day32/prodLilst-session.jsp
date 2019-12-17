<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!-- 设置编码 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>购物侧~~ O(∩_∩)O哈哈~</title>
</head>
<body>
<!-- 开始光标位置 -->

	pageContext.request.contextPath : ${pageContext.request.contextPath }
	<!-- 开始光标位置 -->
	<h3>点击商品链接，可以将商品加入购物车</h3>
	<%--cart 购物车 --%>
	<p><a href="${pageContext.request.contextPath }/CartServlet_session?prod=iphone11">iphone11</a></p>
	<p><a href="${pageContext.request.contextPath }/CartServlet_session?prod=huaweimeta30">huaweimeta30</a></p>
	<p><a href="${pageContext.request.contextPath }/CartServlet_session?prod=vivonex3">vivonex3</a></p>
	<p><a href="${pageContext.request.contextPath }/CartServlet_session?prod=小米手机">小米手机</a></p>
	
	-----<br>
	

	<hr>
	<h3>点击支付链接，可以对购物车商品进行结算</h3>
	<p><a href="${pageContext.request.contextPath }/PayServlet_session">支付</a></p>
	



</body>
</html>