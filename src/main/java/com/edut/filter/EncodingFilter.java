package com.edut.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter extends HttpFilter {
	
	private String encoding ; 
	@Override
	public void init() throws ServletException {
		super.init();
		String par = "Encoding";
		encoding = getFilterConfig().getServletContext().getInitParameter(par);
	}
	
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("###########  @@@@@@@@@@  Encoding"+ " ... " + encoding );
		req.setCharacterEncoding("utf-8");
		
		chain.doFilter(req, res);
	}
}
