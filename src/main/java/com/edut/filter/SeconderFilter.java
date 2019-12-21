package com.edut.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SeconderFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("seconder filter destroy ... ");
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("seconder filter init ...");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("seconder filter do filter .... ");
		
		chain.doFilter(request, response);
	}

}
