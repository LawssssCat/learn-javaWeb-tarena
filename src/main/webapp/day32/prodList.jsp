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
	pageContext.request.contextPath : ${pageContext.request.contextPath }
	<!-- 开始光标位置 -->
	<h3>点击商品链接，可以将商品加入购物车</h3>
	<%--cart 购物车 --%>
	<p><a href="${pageContext.request.contextPath }/CartServlet?prod=iphone11">iphone11</a></p>
	<p><a href="${pageContext.request.contextPath }/CartServlet?prod=huaweimeta30">huaweimeta30</a></p>
	<p><a href="${pageContext.request.contextPath }/CartServlet?prod=vivonex3">vivonex3</a></p>
	<p><a href="${pageContext.request.contextPath }/CartServlet?prod=小米手机">小米手机</a></p>
	
	-----<br>
	
	<c:set var="str" value="未选中...."></c:set>
	<c:forEach items="${pageContext.request.cookies }" var="c">
	<c:if test="${ c.name == 'cart' }">
		<c:set var="str" value="${c.value }"></c:set>
	</c:if>
	<%--${c.value } --%>
	</c:forEach>
	已选：${str }
	<br>
	
	
	<hr>
	<h3>点击支付链接，可以对购物车商品进行结算</h3>
	<p><a href="${pageContext.request.contextPath }/PayServlet">支付</a></p>
	
	<c:if test="${not empty pay }">
	成功支付!...${pay}<br>
	</c:if>
	
</body>
</html>