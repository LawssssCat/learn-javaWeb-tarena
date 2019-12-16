<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="cn.edut.day30.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>	
<body>
	<%
		User user = new User() ; 
		user.setName("张珊");
		user.setAge(23);
		user.setBirthday(new Date());
		
		request.setAttribute("u", user);
		user.setName("------------错误！！！~");
	%>
	
	<h3>获取对象中的值</h3>
	${requestScope.u}<br>
	${request.u.name}<br>
	${u.age}<br>
	${u.birthday}<br>
	${u.birthday.month}<br>
	----- 做 Date 格式化 ---<br>
	${u.birthdayStr}<br>
	
	<hr>
	<h3>获取List值</h3>
	<%
		List list = new ArrayList() ; 
		list.add("张珊");
		list.add("李四");
		list.add(user) ; 
		request.setAttribute("list", list);
		
	%>
	${list }<br>
	${list[0] }<br>
	${list[1] } <br>
	----如果下标越界.... ----<br>
	${list[10] }<br>
	-----什么都不显示<br>
	${list[2].name }<br>
	
	
	<hr>
	<h3>获取Map值</h3>
	<%
		Map map = new HashMap();
		map.put("name", "李四");
		map.put("gender", "男");
		map.put("user", user);  //上面的user
		request.setAttribute("map", map) ;
		
	%>
	${map.name}<br>
	${map["gender"]}<br>
	${map['user'].birthdayStr}
	
	<hr>
	<h3>empty运算符</h3>
	<%
		String str ="abc" ; 
		request.setAttribute("str", str);
		
		String str2 = "" ; 
		request.setAttribute("str2", str2) ;
		
	%>
	
	${empty str } <br> <%--false --%>
	${empty str2 } <br> <%--true --%>
	${!empty str2 } <br> <%--false --%>
	${not empty str2 } <br> <%--false --%>
	<hr>
</body>
</html>