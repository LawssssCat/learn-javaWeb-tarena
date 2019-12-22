package com.edut.authority.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edut.authority.Authority;
import com.edut.authority.User;
import com.edut.authority.dao.AuthorityDao;
import com.edut.authority.dao.UserDao;

/**
 * Servlet implementation class AuthorityServlet
 */
public class AuthorityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodName = request.getParameter("method");
		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class , HttpServletResponse.class);
			method.setAccessible(true);
			method.invoke(this, request , response) ; 
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		request.getRequestDispatcher("/authority/authority-manager.jsp").forward(request, response);
	}
	
	private UserDao userDao  ; 
	private AuthorityDao authorityDao  ; 
	
	@Override
	public void init() throws ServletException {
		super.init();
		 userDao = new UserDao()  ; 
		 authorityDao = new AuthorityDao() ; 
	}
	
	protected  void getAuthorities(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String username = request.getParameter("username");
		User user = userDao.getUser(username);
		request.setAttribute("user", user);
		
		List<Authority> allAuthority = new ArrayList<Authority>(authorityDao.getAllAuthority().values());
		request.setAttribute("allAuthority", allAuthority);
	}
	protected  void updateAuthority(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		String username = request.getParameter("username");
		List<Authority> authorities = new ArrayList<Authority>();
		String[] authoritiesStr = request.getParameterValues("authority");
		if(authoritiesStr==null) {
			authoritiesStr = new String[] {} ;
		}
		for (String authorityName : authoritiesStr) {
			authorities.add(authorityDao.getAuthority(authorityName)) ; 
		}
		userDao.updateAuthority(username, authorities );
		
		getAuthorities(request , response);
	}
	
}
