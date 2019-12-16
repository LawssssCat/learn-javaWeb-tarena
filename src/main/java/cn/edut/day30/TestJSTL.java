package cn.edut.day30;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestJSTL
 */
public class TestJSTL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestJSTL() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//不加这个，有中文，一定乱码
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//1. 传递List信息
		List<User> uList = new ArrayList<>() ;
		uList.add(new User("张珊",23,new Date(new Random().nextLong()))) ; 
		uList.add(new User("未完",15,new Date(new Random().nextLong()))) ; 
		uList.add(new User("萨芬",56,new Date(new Random().nextLong()))) ; 
		uList.add(new User("发呃呃",11,new Date(new Random().nextLong()))) ; 
		uList.add(new User("我上班",23,new Date(new Random().nextLong()))) ; 
		request.setAttribute("uList", uList);
		
		//2. 传递map信息
		Map map = new HashMap() ;
		map.put("name", "张珊");
		map.put("age", 23) ; 
		map.put("birthday", new Date()) ;
		request.setAttribute("map", map);
		
		
		request.getRequestDispatcher("day31/testJSTL.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
