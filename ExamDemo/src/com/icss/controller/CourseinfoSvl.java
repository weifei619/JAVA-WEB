package com.icss.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





public class CourseinfoSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public  CourseinfoSvl() {
		super();
	}


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			request.setAttribute("title", "课程信息管理");
			request.setAttribute("path", "course.jsp");
			Object a1=request.getSession().getAttribute("account");		
		    request.setAttribute("a", a1);
request.getRequestDispatcher("admin/admin.jsp").forward(request, response);

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
