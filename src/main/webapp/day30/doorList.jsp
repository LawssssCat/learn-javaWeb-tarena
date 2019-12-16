<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>门店信息 ^_^</title>
</head>
<body>
	<% 
		List list = (List)request.getAttribute("doorList") ;
		Iterator it = list.iterator() ; 
		while(it.hasNext()){
	%>
		<%=it.next()+"<br>" %>	
	<% 
		}
	%>
	 
	<%="<p>"+new Date() +"</p>"%>
	<hr>
	${requestScope.doorList }
</body>
</html>