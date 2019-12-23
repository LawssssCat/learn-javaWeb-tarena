package com.edut.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.catalina.SessionEvent;
import org.apache.catalina.SessionListener;

public class HelloServletContextListener 
implements ServletContextListener , ServletRequestListener , HttpSessionListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("@@@@@@@@ context init ... listener ... ");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("@@@@@@@@ context destroy ... listener ...");
	}
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("@@@@@@@@ request init ... listener ... ");
	}
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("@@@@@@@@ request destroy ... listener ...");
	}
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("@@@@@@@@ session create ... listener ...");
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("@@@@@@@@ session destroy ... listener ...");
	}
	
}
