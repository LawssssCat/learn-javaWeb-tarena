package cn.edut.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class SpringServletContextLinstener
 *
 */
public class SpringServletContextLinstener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public SpringServletContextLinstener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  {
    	//1. 创建 IOC 容器
    	//2. 把 IOC 容器放在 ServletContext 的一个属性中
    	
    }
	
}
