package cn.edut.day32;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartServlet_session
 */
public class CartServlet_session extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet_session() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//不加这个，有中文，一定乱码
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//1.获取即将要加入购物车的商品信息
		String prod = request.getParameter("prod");
		//2.获取一个session对象，并将商品保存到 session 中
		HttpSession session = request.getSession();  
		// false 时候，没有session 就返回null  request.getSession(false);
		// true 时候，没有session 创建session  request.getSession(true);
		session.setAttribute("cart", prod);
		
		//3. 做出回应
		out.write("成功将["+ prod +"]加入了购物车~~~~");
		
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
