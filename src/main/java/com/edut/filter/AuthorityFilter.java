package com.edut.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edut.authority.Authority;
import com.edut.authority.User;
import com.edut.authority.dao.UserDao;

/**
 * Servlet Filter implementation class AuthorityFilter
 */
public class AuthorityFilter extends HttpFilter implements Filter {
   @Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
	   //不拦截
	   String[] nofilterPagesName = getFilterConfig().getInitParameter("nofilter").split(",");
	   String profix = getFilterConfig().getInitParameter("profix");
	   
	   String uri = req.getRequestURI();
	   String webpro = req.getContextPath();
	   String webapp = uri.substring(webpro.length()) ; 
	   System.out.println(webapp);
	   for (String nofilter : nofilterPagesName) {
		   if((profix+nofilter.trim()).equals(webapp)) {
			   chain.doFilter(req, res);
			   return ;
		   }
	   }
	   //有权限
	   User user = (User) req.getSession().getAttribute("user");
	   if(user != null) {
		   List<Authority> authorities = user.getAuthorities();
		   for (Authority authority : authorities) {
			   System.out.println(profix+authority.getUrl()+ " --- "+ webapp);
			   if((profix+authority.getUrl()).equals(webapp)) {
				   chain.doFilter(req, res);
				   return ;
			   }
		   }
	   }
	   //要求登陆
	   req.setAttribute("msg", "未登录或权限不足！");
	   req.getRequestDispatcher(profix + "/login.jsp").forward(req, res);
	}

   @Override
	public void destroy() {
	}
}
