package com.edut.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class PasswordFilter
 */
public class PasswordFilter implements Filter {

    /**
     * Default constructor. 
     */
    public PasswordFilter() {
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
		String p = "password";
		String initPassword = request.getServletContext().getInitParameter(p);
		String password = request.getParameter(p);
		if(!initPassword.equals(password)) {
			String message = "密码错误!!" ;
			request.setAttribute("message", message);
			request.getRequestDispatcher("/my/login.jsp").forward(request, response);
			
			return ; 
		}
		
		System.out.println("登录成功！");
		chain.doFilter(request, response);
	}

	private FilterConfig fConfig  ; 
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig ; 
	}
}
