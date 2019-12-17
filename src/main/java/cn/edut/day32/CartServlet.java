package cn.edut.day32;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 负责将商品加入购物车
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
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
		
		//生成一个Cookie
		String name = "prod" ; 
		String pord =  request.getParameter(name) ;
		// request.getAttribute(name) ; 获取 存放在域中的属性
		// request.getParameter(name) ; 获取参数，浏览器带给服务器的参数（没有set方法）
		
		//pord = URLDecoder.decode(pord, "ascii") ; 
		Cookie cookie = new Cookie("cart", pord );
		cookie.setMaxAge(60*60*24*30);
		//cookie.setDomain(pord);
		//发送一个Cookie
		response.addCookie(cookie);
		
		Cookie[] cookies = request.getCookies();
		System.out.println("<<<----客户端发来 Cookies...");
		for (Cookie c : cookies) {
			System.out.println(c.getName() + ":"+ c.getValue());
		}
		
		String url = "day32/prodList.jsp";
		System.out.println("---->>>服务器 重定向..."+url);
		response.sendRedirect(url);
		
		//request.getRequestDispatcher("day32/prodList.jsp").forward(request, response);
		
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
