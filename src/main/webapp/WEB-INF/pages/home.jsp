<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!-- 设置编码 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title></title>
<script type="text/javascript">
	var person = {	
		"name" : "张飞", 
		"age" : 18, 
		"friends" :["关羽", "刘备"],
		"sayHi" : function(str){ alert("person.sayHi().."+str) }
	};
	person.name;		// 张飞
	person.age;		// 18
	person.friends;	// ["关羽", "刘备"]
	// 弹框提示 person.sayHi()..
	person.sayHi("name:"+person.name+",age:"+ person.age+",friends:" +person.friends);	
	
</script>

</head>
<body>
<!-- 开始光标位置 -->
<h1>day35 - springmvc....home.jsp...</h1>

<font color="red" size="20px">
	name:${name }<br>
	age:${age }<br>
</font>
</body>
</html>