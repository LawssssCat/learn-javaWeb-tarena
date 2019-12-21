package com.edut.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class UsernameFilter
 */
public class UsernameFilter implements Filter {
		

    /**
     * Default constructor. 
     */
    public UsernameFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String arg = "username" ; 
		String initUsername = filterConfig.getInitParameter(arg);
		String username = request.getParameter(arg);
		if(!initUsername.equals(username)) {
			String message = "用户名不正确!";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/my/login.jsp").forward(request, response);
			return ; 
		}
		System.out.println("<<---- "+username+"登录...");
		// pass the request along the filter chain
		chain.doFilter(request, response);
		System.out.println("after dofilter ... username ... ");
		
	}

	private FilterConfig filterConfig  ; 
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		filterConfig = fConfig ; 
	}

}
