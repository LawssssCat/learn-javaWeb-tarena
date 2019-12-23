package com.edut.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter extends HttpFilter implements Filter {
	
	
	FilterConfig config ; 
	ServletContext context ; 
	@Override
	public void init() throws ServletException {
		super.init();
		config = getFilterConfig();
		context = config.getServletContext();
	}

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
    		throws IOException, ServletException {
    	if(isLogin(req) || isFilter(req) ) {
    		chain.doFilter(req	, res);
    		return ;
    	}else{
        	String redirectPage = context.getInitParameter("redirectPage");
        	req.getRequestDispatcher(redirectPage).forward(req, res);
    	}
    }
    
	
    private boolean isFilter(HttpServletRequest req) {

    	String uncheckedUrls = context.getInitParameter("uncheckedUrls");
    	String[] urls = uncheckedUrls.split(",");
    	
    	//String URL = req.getRequestURL().toString();
    	String uri = req.getRequestURI();
    	String contextPath = req.getContextPath();
    	//System.out.println(URL);
    	//System.out.println(uri);
    	//System.out.println(contextPath);
    	String webapp = uri.substring(contextPath.length(), uri.length());
    	//System.out.println(webapp);
    	for (String url : urls) {
        	
    		if(webapp.equals(url.trim())) {
    			return true;
    		}
		}
		return false;
	}


    
	
	private boolean isLogin(HttpServletRequest req) {
		HttpSession session = req.getSession();
		Object username = session.getAttribute("username");
		String initUsername = context.getInitParameter("username");
		if(initUsername.equals(username)) {
			return true ;
		}else {
			return false ;
		}
	}
	
	@Override
	public void destroy() {
	}
	
}
