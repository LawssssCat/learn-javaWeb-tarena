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
	<%
		//1. 获取用户的登录信息
		String username = request.getParameter("username") ;
		String webapps = config.getServletContext().getContextPath() ; 
		//2. 若登录信息完整，则把登录信息放到 HttpSession
		//注意：循序,要先判断非空
		if(username != null && !"".equals(username.trim())) {
			session.setAttribute("username", username) ;
			//3. 重定向到 list.jsp
			response.sendRedirect("list.jsp") ; 
		}else{
			response.sendRedirect(webapps+ "/login/login.jsp") ; 			
		}
	%>
</body>
</html>