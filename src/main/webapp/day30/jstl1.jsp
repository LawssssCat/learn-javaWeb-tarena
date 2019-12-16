<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--添加标签 ！ --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>c:if标签</h3>
	1. 属性<br>
	* test 必须属性，接收boolean表达式<br>
	* 如果表达式为true，则显示if标签体内容，<br>
	* 如果false，则不显示标签体内容。 <br>
	<br>
	注意：c:if标签没有else情况
	<br>
	
	 一般情况下，test属性值会结合el表达式一起使用
	<c:if test="true">
		<h5>我是真</h5>
	</c:if>
	<br>
	<c:if test="false">
		<h5>我是假</h5>
	</c:if>
	<br>
	
	<%
		/*
		* 判断request域中的一个list集合是否为空
		* 如果不为null，则显示遍历集合
		*/
		List list = new ArrayList() ;
		list.add("aaaa") ; 
		request.setAttribute("list",list) ;
		request.setAttribute("number", 3) ; 
	%>
	
	<c:if test="${not empty list }">
		遍历集合....
	</c:if>
	<br>
	
	<c:if test="${number % 2 !=0 }">
		${number }为奇数
	</c:if>
	<c:if test="${number % 2 == 9 }">
		${number }为偶数
	</c:if>
	
	<hr>
	<h3>choose 标签</h3>
	完成数字编号对应星期几 案例 <br>
	1. 域中存储数字<br>
	2. 使用choose标签取出数字 - 相当于 case<br>
	3. 使用我很标签做数字判断<br>
	4. otherwise标签做其他情况的声明 - 相当于  default<br>
	
	<%
		request.setAttribute("number", 3) ; 
	%>
	<c:choose>
		<c:when test="${number==1 }">星期一</c:when>
		<c:when test="${number==2 }">星期二</c:when>
		<c:when test="${number==3 }">星期三</c:when>
		<c:when test="${number==4 }">星期四</c:when>
		<c:when test="${number==5 }">星期五</c:when>
		<c:when test="${number==6 }">星期六</c:when>
		<c:when test="${number==7 }">星期日</c:when>
		
		<c:otherwise>数字输入有误！</c:otherwise>
	</c:choose>
	
	<hr>
	<h3>foreach标签</h3>
	foreach：箱单于java代码for语句<br>
	<br>
	1. 完成重复操作<br>
	- 属性：<br>
	- - begin，开始值<br>
	- - end，结束值<br>
	- - var，临时变量<br>
	- - step，步长<br>
	- - varStatus，循环状态对象<br>
	- - - [这个属性，在遍历容量里用]index:容器中元素的索引，(遍历容器时)从0开始<br>
	- - - count:循环次数，从1开始<br>
	<br>
	2. 遍历容器<br>
	- 属性：<br>
	- - items，容器对象<br>
	- - var，容器中元素的临时变量<br>
	- - varStatus，循环状态对象<br>
	- - - index:容器中元素的索引，(遍历容器时)从0开始<br>
	- - - count:循环次数，从1开始<br>
	
	<br>
	---完成重复操作 - 例子 -----<br>
	<c:forEach begin="2" end="15" var="i" step="2" varStatus="s">
		i=${i } -  s.index=${s.index } -  s.count=${s.count } <br>
	</c:forEach>
	<br>
	
	---遍历容器 - 例子 --------<br>
	<%
		List l = new ArrayList() ; 
		l.add("aaaa") ; 
		l.add("bbbb") ; 
		l.add("cccc") ; 
		l.add("dddd") ; 
		
		request.setAttribute("list", l) ; 
	%>
	<c:forEach items="${list }" var="str" varStatus="s" >
		s.index=${s.index } - s.count=${s.count } - str=${str } <br>
	</c:forEach>
	
</body>
</html>