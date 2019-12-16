package cn.edut.day30;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class doorList
 */
public class DoorList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoorList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//不加这个，有中文，一定乱码
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List<String> doorList = new ArrayList<String>() ; 
		doorList.add("广州门店 0010-81613496768746") ; 
		doorList.add("澳门门店 0020-44444444448746") ; 
		doorList.add("纽约门店 0030-55553496142124") ; 
		doorList.add("香港门店 0040-61613124214746") ; 
		doorList.add("日本门店 0050-77777776768746") ; 
		doorList.add("杭州门店 0060-81613455555556") ;
		request.setAttribute("doorList", doorList);
		request.getRequestDispatcher("day30/doorList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
