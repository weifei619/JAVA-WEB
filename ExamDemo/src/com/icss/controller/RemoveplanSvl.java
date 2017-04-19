package com.icss.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.AdminBiz;
import com.icss.entity.Texam;

public class RemoveplanSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public RemoveplanSvl() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   String examid1=request.getParameter("examid");
		    int examid=Integer.valueOf(examid1);
		    AdminBiz biz=new AdminBiz();
		try {
			biz.removeplan(examid);
			List<Texam> exam=biz.queryallexam();
			request.setAttribute("exam",exam);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("title", "øº ‘–≈œ¢±‡º≠");
		request.setAttribute("path", "editexamplan.jsp");
		Object a1=request.getSession().getAttribute("account");		
		request.setAttribute("a", a1);
		request.getRequestDispatcher("admin/admin.jsp").forward(request, response);

	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		   String examid1=request.getParameter("examid");
//		    int examid=Integer.valueOf(examid1);
//		    AdminBiz biz=new AdminBiz();
//		try {
//			biz.removeplan(examid);
//			List<Texam> exam=biz.queryallexam();
//			request.setAttribute("exam",exam);
//			
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		request.setAttribute("title", "øº ‘–≈œ¢±‡º≠");
//		request.setAttribute("path", "editexamplan.jsp");
//		Object a1=request.getSession().getAttribute("account");		
//		request.setAttribute("a", a1);
//		request.getRequestDispatcher("admin.jsp").forward(request, response);

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
