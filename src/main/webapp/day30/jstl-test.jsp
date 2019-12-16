<%@page import="java.util.Date"%>
<%@page import="cn.edut.day30.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	需求1：<br>
	在request域中，有一个存有user对象的List集合<br>
	需要使用jstl+el将list集合数据展示到jsp页面的表格table中<br>
	<%
		List list = new ArrayList() ; 
		list.add(new User("张珊", 23, new Date())) ;
		list.add(new User("李四", 24, new Date())) ;
		list.add(new User("王五", 25, new Date())) ;
		
		request.setAttribute("list", list);
	%>
	
	<table border="1px">
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>生日</th>
		</tr>
		<c:forEach items="${list }" var="user" varStatus="index">
		<tr>
			<td>${index.count }</td>
			<td>${user.name}</td>
			<td>${user["age"] }</td>
			<td>${user.birthdayStr}</td>
		</tr> 
		</c:forEach>
	</table>
	
	<hr>
	需求2：<br>
	隔行变色<br>
	<table border="1px">
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>生日</th>
		</tr>
		<c:forEach items="${list }" var="user" varStatus="index">
			<c:if test="${index.count %2==0}">
				<tr bgcolor="green">
					<td>${index.count }</td>
					<td>${user.name}</td>
					<td>${user["age"] }</td>
					<td>${user.birthdayStr}</td>
				</tr> 
			</c:if>
			<c:if test="${index.count%2!=0 }">
				<tr background="red">
					<td>${index.count }</td>
					<td>${user.name}</td>
					<td>${user["age"] }</td>
					<td>${user.birthdayStr}</td>
				</tr> 
			</c:if>
		</c:forEach>
	</table>
	
</body>
</html>