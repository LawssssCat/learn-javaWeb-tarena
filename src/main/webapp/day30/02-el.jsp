<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!-- 设置编码 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title></title>
</head>
<body>
<!-- 开始光标位置 -->
	<h3>1、获取常量、表达式、变量的值（变量得先存入域中）</h3>
	${ "Hello EL" }
	${ 100+23 }
	<hr>
	<%="Hello EL" %>
	<%=100+23 %>
	<hr>
	<p>如果EL中存放的是常量或表达式，结果是直接将常量的值或者表达式的计算结果输出到当前位置<br>
	如果EL中存放的是变量，底层会根据变量的名字作为key到四大作用域中寻找指定的value，寻找时是按照四大作用于的大小来寻找，寻找顺序是从小到大<br>
	如果找到就返回value值，如果找不到也不会返回null，二十什么都不输出！</p>
	<br>
	----- 如下 ---<br>
	
	<%
		String name = "张飞";
		request.setAttribute("name1", name);
	%>
	${name1}
	
	<hr>
	<h3>2、获取作用域中数组或集合中的元素</h3>
	<p> 创建一个 Servlet，在Servlet中声明一个数组或集合，将数组或集合存入到request作用域中，<br>
	通过转发，将request及其中的数据带到当前jsp中，<br>
	在jsp中通过EL获取数组或集合中的元素
	</p>
	<br>
	--- 如下   - ---
	<br>
	先写一个Servlet，实现转发一个数组<br>
	转发结果打印：<br>
	<%String[] names = (String[])request.getAttribute("ns"); %>
	<%for(int i=0 ; i<names.length ; i++){%>
	<%="-"+i+". "+ names[i]+"<br>" %>
	<%} %>
	<br>
	--- 如下 -  ---<br>
	${ ns[0] } <br>
	${ ns[1] }<br>
	${ ns[2] }<br>
	${ ns[3] }<br>
	Note:EL本身无法遍历，需要和标签配合。后面说....<br>
	
	
	
	<hr>
	<h3>2、获取作用域中数组或集合中的元素</h3>
	<P> --- ---  通过字符串获取 --- --- </P>
	${map==null}
	${map}<br> <!-- 直接打印遍历结果 -->
	${map["a"] }<br>
	${map.get("b")}<br>
	${map.c }<br>
	<P> --- ---  通过数字获取 --- --- </P>
	${map2==null}<br>
	${map2.get(1) }<br>
	${map2[1] } <br>
	<p>注意：
1、Map集合的key最好符合Java标识符规范，如果不符合，则在EL表达式中不能使用.的方式获取到Map相应的value,只能通过[]的方式获取到相应的value;
2、Map集合key的泛型不能是Java基本数据类型的包装类，否则EL表达式无论使用那种方式都无法获取到相应的value。
</p>
	
	<hr>
	<h3>3. 声明一个User对象，并将User对象存入request域中</h3>
	
	${u1 } <br>
	
	
	
	
	<hr>
	<h3>4、获取作用域中JavaBean对象的属性值</h3>
	<!-- u1.name  底层调用的是 u1.getName() -->
	name=${u1.name } <br>
	age=${u1.age}<br>
	addr=${u1.birthdayStr }<br>
	
	<hr>
</body>
</html>