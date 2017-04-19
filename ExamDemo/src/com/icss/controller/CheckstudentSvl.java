package com.icss.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.AdminBiz;
import com.icss.entity.Tstudent;
import com.icss.exception.ObjectNullException;



public class CheckstudentSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public CheckstudentSvl() {
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

//	String sno=request.getParameter("no");
//	System.out.println(sno);
//	AdminBiz biz=new AdminBiz();
//	try {
//		Tstudent s=biz.checkstudent(sno);
//		request.setAttribute("s", s);
//	} catch (ObjectNullException e) {
//		e.getMessage();
//	}catch(Exception e){
//		request.setAttribute("msg", "发生未知错误，请联系管理员");
//		String path = "error/error.jsp";
//		request.getRequestDispatcher(path).forward(request, response);		
//	}
//	
//	request.setAttribute("path", "studentinfo.jsp");
//	request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
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


		String sno=request.getParameter("no");
		
		if(sno !=null && !sno.equals("")){
			
		AdminBiz biz=new AdminBiz();
		try {
			Tstudent s=biz.checkstudent(sno);
			request.setAttribute("s", s);
		} catch (ObjectNullException e) {
			e.printStackTrace();
		}catch(Exception e){
			request.setAttribute("msg", "发生未知错误，请联系管理员");
			String path = "error/error.jsp";
			request.getRequestDispatcher(path).forward(request, response);		
		}
		request.setAttribute("title", "学生信息查询");
		request.setAttribute("path", "studentinfo.jsp");
		Object a1=request.getSession().getAttribute("account");		
	    request.setAttribute("a", a1);
		request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
		}
		else{
request.setAttribute("title", "学生信息管理");
request.setAttribute("path", "student.jsp");
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
