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
	<!-- session是服务端技术， -->

	<!-- 开始光标位置 -->
	<h3>持久保存 session</h3>
	<form action="${pageContext.request.contextPath}/SessionLonger" method="get">
		<input type="text" name="msg" >
		<input type="submit" value="更新msg .." >
	</form>
	
	<hr>
	session:...<br>
	${sessionScope } <br>
	<c:forEach items="${sessionScope }" var="i">
		${i.key } -  ${i.value } <br>
	</c:forEach>
	---<br>
	
	
	<c:if test="${not empty msg }">
	Hi！ -- <b>>关闭浏览器，再打开这地址试试</b>~~  O(∩_∩)O~~<br>
	</c:if>
	
	
	<hr>

	每次回传新的Cookie<br>
	但内容不变~<br>

	---<br>
	<c:set var="i" value="0"></c:set>
	cookies:...<br>
	数组  ===>   ${pageContext.request.cookies }<br>
	数组[0] ===> ${pageContext.request.cookies[i]}<br>
	--<br>
	cookie ===> ${cookie } <br>
	cookie[JSESSIONID] ===> ${cookie["JSESSIONID"] } <br>
	cookie[JSESSIONID].value ===> ${cookie["JSESSIONID"].value } <br>
	session.id ==> ${pageContext.session.id }<br>
	
	---<br>
	<c:forEach items="${cookie }" var="c">
		${c.key } : ${c.value.name }:  ${c.value.value} }<br>
	</c:forEach>

</body>
</html>