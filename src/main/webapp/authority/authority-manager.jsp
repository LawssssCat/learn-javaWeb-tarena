<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>权限管理</h3>
	<!-- AuthorityServlet?method=getAuthorities&&username=xxx -->
	<form action="${pageContext.request.contextPath }/AuthorityServlet?method=getAuthorities" method="post">
		username:<input type="text" name="username" > 
		<input value="Submint" type="submit" ><br>
	</form>
	
	<hr>
	<c:if test="${not empty user }">
		${user.name }权限：<br> 
		<form action="AuthorityServlet?method=updateAuthority" method="post">
			<input name="username" value="${user.name }" hidden="true">
			<!-- 遍历所有权限 -->
			<c:forEach items="${allAuthority  }" var="authority" varStatus="s">
				<!-- 默认用户没有此权限 -->
				<c:set var="flag" value="false"></c:set>
				<!-- 查看 user 是否有此权限 -->
				<c:forEach items="${user.authorities }" var="a">
					<c:if test="${a.name == authority.name }">
						<c:set var="flag" value="true"></c:set>
					</c:if>
				</c:forEach>
				<!-- 显示所有权限 -->
				<c:if test="${flag==false}">	
					<input type="checkbox" 
					name="authority" 
					value="${authority.name }"> ${authority.name} <br>
				</c:if>
				<c:if test="${flag==true}">	
					<input type="checkbox" 
					name="authority" 
					value="${authority.name }" 
					checked="checked" > ${authority.name} <br>
				</c:if>
			</c:forEach>
			<input type="submit" value="update">
		</form>
	</c:if>
</body>
</html>