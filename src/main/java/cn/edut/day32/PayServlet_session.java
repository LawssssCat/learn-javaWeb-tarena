package cn.edut.day32;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PayServlet_session
 */
public class PayServlet_session extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PayServlet_session() {
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
		
		//获取之前的Session
		//并冲 session 中获取到要结算的商品信息
		Object prod =  request.getSession().getAttribute("cart");
		
		if(prod==null) {
			out.write("您还没有将任何商品加入购物车！");
			
		}else {
			//模拟支付
			out.write("成功为["+prod+"]支付了2000元~~~");
			
		}
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
