package cn.edut.day30;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edut.day30.User;

/**
 * Servlet implementation class TestEL
 */
public class TestEL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestEL() {
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
		
		String url = "day30/02-el.jsp";
		System.out.println("转发...to..."+ url);
		
		//1.声明一个数组，并将数据存入request域中
		String[] names = {"刘德华","郭富城","张学友","王海涛"};
		request.setAttribute("ns", names);
		
		
		//2.声明一个map集合，并将map集合存入request域中。
		Map<String ,String> map = new HashMap<>();
		
//		for(int i=0 ; i<names.length ; i++ ) {
//			map.put(""+i, names[i]);
//		}
		map.put("a", "张珊");
		map.put("b","李四") ;
		map.put("c","王五") ;
		request.setAttribute("map", map);
		
		Map<Integer, String > map2 = new HashMap<Integer, String>() ;
		
		/*
		 * 注意：
				1、Map集合的key最好符合Java标识符规范，
					如果不符合，则在EL表达式中不能使用.的方式获取到Map相应的value,
					只能通过[]的方式获取到相应的value;
				2、Map集合key的泛型不能是Java基本数据类型的包装类，
					否则EL表达式无论使用那种方式都无法获取到相应的value。
		 */
		map2.put(1, "刘备");
		
		request.setAttribute("map2", map2);
		
		
		//3. 声明一个User对象，并将User对象存入request域中
		User u1 = new User("关羽", 30 , new Date());
		request.setAttribute("u1", u1);
		
		//4、获取作用域中JavaBean对象的属性值
		
		
		//通过转发，将request及其中的数据带到jsp中
		request.getRequestDispatcher(url).forward(request, response);
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
