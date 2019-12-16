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

<!-- 开始光标位置 -->
<!-- 打印list数据 -->
<c:forEach items="${uList }" var="u" varStatus="s" >
	${s.count } , ${u.name } , ${u.age } , ${u.birthdayStr } <br>
</c:forEach>


<hr>

<!-- 遍历map数据 -->
<c:forEach items="${map }" var="u" varStatus="s">
	${u}   <br> 
</c:forEach>
	
</body>
</html>