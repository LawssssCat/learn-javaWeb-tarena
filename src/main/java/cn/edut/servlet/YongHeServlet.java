package cn.edut.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import cn.edut.pojo.Empolyee;
import cn.edut.service.YongHeService;

/**
 * Servlet implementation class YongHeServlet
 */
public class YongHeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private YongHeService  yongHeService; 
	private ClassPathXmlApplicationContext ctx  = null ; 
	
	{
		ctx = new ClassPathXmlApplicationContext("classpath:yonghe.xml") ;
		yongHeService = ctx.getBean(YongHeService.class) ; 
	}
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public YongHeServlet() {
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
		
		List<Empolyee> employeeList = yongHeService.getAllEmployee();
		
		request.setAttribute("employeeList", employeeList);
		
		request.getRequestDispatcher("list.jsp").forward(request, response);
		
		
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
