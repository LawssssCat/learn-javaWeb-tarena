package com.edut;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet implements Servlet{

	@Override
	public void destroy() {
		System.out.println("destroy...");
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("configuring...");
		return null;
	}

	@Override
	public String getServletInfo() {
		System.out.println("infoing...");
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("initing...");
		String user = config.getInitParameter("user");
		System.out.println(user);
		
		Enumeration<String> ee = config.getInitParameterNames();
		while (ee.hasMoreElements()) {
			String key = (String) ee.nextElement();
			String value = config.getInitParameter(key);
			System.out.println(key + " : " + value);
		}
		
		String name = config.getServletName();
		System.out.println(name);
		
		System.out.println("-------------");
		
		//获取 ServletContext 对象
		ServletContext servletContext = config.getServletContext() ;
		String driver = servletContext.getInitParameter("driver");
		System.out.println("driver:"+driver);
		
		Enumeration<String> ps = servletContext.getInitParameterNames();
		while(ps.hasMoreElements()) {
			String key = ps.nextElement();
			String value = servletContext.getInitParameter(key);
			System.out.println("key:"+key+" - "+ "value:"+ value);
		}
		
		System.out.println("-------------------");
		//获取部署后，的绝对路径（在服务器上的绝对路径）
		String realPath = servletContext.getRealPath("/index.jsp");
		System.out.println(realPath);
		
		
		System.out.println("-------------------");
		//获取当前WEB应用的名称
		String contextPath = servletContext.getContextPath();
		System.out.println(contextPath);
		
		
		System.out.println("-------------------");
		System.out.println("class.getResource:"+getClass().getResource(""));
		System.out.println("class.getResource/:"+getClass().getResource("/"));
		System.out.println("classloader.getResource:"+getClass().getClassLoader().getResource(""));
		System.out.println("classloader.getResource/:"+getClass().getClassLoader().getResource("/"));
		try {
			System.out.println(servletContext.getResource("/WEB-INF/classes"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputStream in = getClass().getClassLoader().getResourceAsStream("c3p0.properties");
		System.out.println("1..." + in);
		
		InputStream in2 = servletContext.getResourceAsStream("/WEB-INF/classes/c3p0.properties");
		InputStream in3 = servletContext.getResourceAsStream("classpath:c3p0.properties");
		System.out.println("2..."+in2);
		System.out.println("3..."+in3);
		
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("servicing...");
	}

}
