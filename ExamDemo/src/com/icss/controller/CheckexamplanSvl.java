package com.icss.controller;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.AdminBiz;
import com.icss.entity.Texam;

public class CheckexamplanSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public CheckexamplanSvl() {
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
//		   String examid1=request.getParameter("examid");
//		    int examid=Integer.valueOf(examid1);
//		    AdminBiz biz=new AdminBiz();
//			Texam exam;
//			try {
//				exam = biz.queryexam(examid);
//				request.setAttribute("exam",exam);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			request.setAttribute("title", "考试信息编辑");
//			request.setAttribute("path", "editexamplan.jsp");
//			Object a1=request.getSession().getAttribute("account");		
//			request.setAttribute("a", a1);
//			request.getRequestDispatcher("admin/admin.jsp").forward(request, response);

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
		try{
		   String examid1=request.getParameter("examid");
		  
			Texam exam;
			
			if(examid1 !=null && !examid1.equals("")){
					  int examid=Integer.valueOf(examid1);
					    AdminBiz biz=new AdminBiz();
			
				exam = biz.queryexam(examid);
				request.setAttribute("e",exam);
			}
			request.setAttribute("title", "考试信息编辑");
			request.setAttribute("path", "examplaninfo.jsp");
			Object a1=request.getSession().getAttribute("account");		
			request.setAttribute("a", a1);
			request.getRequestDispatcher("admin/admin.jsp").forward(request, response);

			} catch (SQLException e) {
				 request.setAttribute("msg", "查询出错 !请确认试题ID!");
				 request.setAttribute("title", "错误信息");
					request.setAttribute("path", "error.jsp");
					Object a1=request.getSession().getAttribute("account");		
					request.setAttribute("a", a1);
					request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
					
			}catch (Exception e) {
				 request.setAttribute("msg", "查询出错! 请确认试题ID!");
				 request.setAttribute("title", "错误信息");
					request.setAttribute("path", "error.jsp");
					Object a1=request.getSession().getAttribute("account");		
					request.setAttribute("a", a1);
					request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
					
			}
		
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
