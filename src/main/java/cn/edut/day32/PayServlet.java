package cn.edut.day32;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 负责对购物车商品进行结算
 */
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PayServlet() {
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
		
		//1 .获取请求中携带的所有cookie组成的数组
		Cookie[] cookies = request.getCookies();
		
		//2 遍历所有Cookie数组，找到名称为Car的Cookie
		String cookieName = "cart" ; 
		for (Cookie cookie : cookies) {
			if(cookieName.equals(cookie.getName())) {
				System.out.println("cookie.value="+cookie.getValue());
				request.setAttribute("pay", cookie.getValue());
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		
		
		request.getRequestDispatcher("day32/prodList.jsp").forward(request, response);
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
