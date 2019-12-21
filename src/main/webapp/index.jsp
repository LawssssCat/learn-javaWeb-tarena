<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
	<!-- 指定字符集 -->
	<meta charset="UTF-8">
	<!-- 使用Edge最新的浏览器的渲染方式 -->
	<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
	<!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
	 	width：默认宽度与设备的宽度相同
	 	initial-scale：初始化缩放比，为1:1
	-->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
	<title>首页 O(∩_∩)O~~</title>
	<!-- 1.导入CSS的全局样式 -->
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<!-- 2.jQuery导入，建议使用1.9以上的版本 -->
	<script src="js/jquery-3.4.1.min.js" type="text/javascript" ></script>
	<!-- 3.导入bootstrap的js文件 -->
	<script src="js/bootstrap.min.js" type="text/javascript"></script>

	<script type="text/javascript">
	$(document).ready(function(){
		//$("td").fadeIn(3000)
	});
	$(function() {
		$("a").addClass("btn btn-default btn-sm myclass" );  //aClass在css文件中定义
		//var tr = $("tr").children("td").;
		$("tr").children("td:first-child").css("text-align" , "center") ;
		$("tr").children("th:first-child").css("text-align" , "center") ;
		//${".success"}.css("text-align" , "center");
	});
		//
		//
	</script>
	
	<style type="text/css">
	th,td{
		font-size:larger;
		align-content: center;
	}
	</style>

</head>

<body>

<div align="center" class="container">
	<table border="100"   class="table table-bordered table-hover">
		<tr class="success">
			<th>练习</th>
			<th>链接</th>
		</tr>
		<tr>
			<td>
				表格练习：
			</td>
			<td>
				<a href="day24/loginout_table.html"  target="_blank">loginout_table</a>
			</td>
		</tr>
		<tr>
			<td>
				css练习：
			</td>
			<td>
				<a href="day24/imgs/02_引入css.html" target="_blank">02_引入css.html</a>
			</td>
		</tr>
		<tr>
			<td>
				css选择器练习：
			</td>
			<td>
				<a href="day24/imgs/03_选择器练习.html">03_选择器练习.html</a>
			</td>
		</tr>
		<tr>
			<td>
				注册界面练习：
			</td>
			<td>
				<a href="day25/regist.html">"京淘"登录/注册界面【案例】</a>
			</td>
		</tr>

		<tr>
			<td>
				js - 语句练习：
			</td>
			<td>
				<a href="day26/js-exercise/02-js语法示例-if.html">02-js语法示例-if</a>
				<br>
				<a href="day26/js-exercise/02-js语法示例-switch.html">02-js语法示例-switch</a>
				<br>
				<a href="day26/js-exercise/02-js语法示例-for.html">02-js语法示例-forh</a>
				<br>
				<a href="day26/js-exercise/02-js语法示例-while.html">02-js语法示例-while</a>
				<br>
				<a href="day26/js-exercise/02-js语法示例-function.html">02-js语法示例-function</a>
				<br>
				<a href="day26/js-exercise/03-电灯开关.html">03-电灯开关</a>
				<br>
				<a href="day26/js-exercise/04-元素的dom操作.html">04-元素的dom操作</a>
				<br>
				<a href="day26/js-exercise/05-网页换肤.html">05-网页换肤</a>
			</td>
		</tr>
		
		<tr>
			<td>
				jQuery 练习：
			</td>
			<td>
				<a href="day27/01-引入jquery.html">1-jQuery引入</a><br>
				<a href="day27/02-jQuery选择器练习.html">2-jQuery选择器练习</a>
				<br>
				<a href="day27/03-全选或全不选.html">03-全选或全不选</a>
				<br>
				<a href="day27/04-创建表格元素.html">04-创建表格元素.html</a>
				<br>
				<a href="day27/05-仿QQ好友分组.html">05-仿QQ好友分组</a>
				<br>
			</td>
		</tr>
		<tr>
			<td>
				Servlet 练习：
			</td>
			<td>
				<a href="index1.jsp">index.jsp</a><br>
				<a href="HelloServlet">01-Hello Servlet!</a><br>
				<a href="DoorList">02-门店信息</a><br>
				<a href="table.jsp">03-表单处理</a><br>
				<a href="TestEL">EL - 获取值</a><br>
				<a href="day30/03-el.jsp">EL - 获取对象值</a><br>
				<a href="day30/04-el.jsp">EL - 虚拟对象</a><br>
				<a href="day30/jstl1.jsp">JSTL-语法</a><br>
				<a href="day30/jstl-test.jsp">综合练习 - el jstl </a><br>
				<a href="TestJSTL">day31/TestJSTL</a><br>
				<a href="day32/prodList.jsp">day32/prodList.jsp - 【购物车案例】</a><br>
				<a href="day32/prodLilst-session.jsp">day32/prodLilst-session.jsp - 【购物车案例 - Session实现】</a><br>
				<a href="day32/session_longer.jsp">session 持久保存</a><br>
			</td>
		</tr>
		<tr>
			<td>
				YongHe - Spring 练习
			</td>
			<td>
				<a href="YongHeServlet">YongHeServlet - 显示所有员工【三层架构】</a><br>
			</td>
		</tr>
		<tr>
			<td>
				filter
			</td>
			<td>
				<a href="test.jsp">filter</a><br>
				<a href="my/login.jsp">login - filter </a><br>
				<a href="my/dispatcher.jsp">dispatcher.jsp</a><br>
				<a href="my/include.jsp">include.jsp</a><br>
				<a href="my/error.jsp">error.jsp</a><br>
				<a href="cache/a.html">cache</a><br>
				<a href="encoding/a.jsp">encoding</a><br>
				<a href="login/a.jsp">检查用户是否登录？</a><br>
			</td>
		</tr>
	</table>
	
</div>
</body>

</html>