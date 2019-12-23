package com.edut.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class NoCacheFilter
 */
public class NoCacheFilter extends HttpFilter implements Filter {
       

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("cacheFilter's doFilter ... ");
		// 设定网页的到期时间，一旦过期则必须到服务器上重新调用
		res.setDateHeader("Expires", -1);
		// Cache-Control 指定请求和响应应遵循的缓存机制 no-cache指示请求或响应消息是不能缓存的
		res.setHeader("Cache-Control", "no-cache");
		// 用于设定禁止浏览器从本地缓存中调用页面内容，设定后一旦离开页面就无法从Cache中再调出
		res.setHeader("Pragma", "no-cache");
		// 放行
		
		chain.doFilter(req, res);
	}

	
}
