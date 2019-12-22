package com.edut.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class TestAttributeListener 
implements ServletContextAttributeListener , 
HttpSessionAttributeListener , 
ServletRequestAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("Session attribute add  ... " +event.getName() + " : "+event.getValue());
	}
	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("context attribute add ..." +event.getName() + " : "+event.getValue());
	}
	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("request attribute add ..." +srae.getName() + " : "+srae.getValue());
	}
	
	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("session attribute replace ... " +event.getName() + " : "+event.getValue());
	}
	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("context attribute replace ... "+event.getName() + " : "+event.getValue());
	}
	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("request attribute replace ... "+srae.getName() + " : "+srae.getValue());
	}
	
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("session attribute remove ..."+event.getName() + " : "+event.getValue());
	}
	
	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("context attribute remove ... "+event.getName() + " : "+event.getValue());
	}
	
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("request attribute remove ... "+srae.getName() + " : "+srae.getValue());
	}
	
}
