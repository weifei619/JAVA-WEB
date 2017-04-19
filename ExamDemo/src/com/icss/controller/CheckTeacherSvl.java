package com.icss.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.AdminBiz;
import com.icss.entity.Tteacher;
import com.icss.exception.ObjectNullException;

public class CheckTeacherSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public CheckTeacherSvl() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String tno=request.getParameter("no");
		if(tno !=null && !tno.equals("")){
		AdminBiz biz=new AdminBiz();
		try {
			Tteacher t = biz.checkteacher(tno);
			request.setAttribute("t", t);              
		} catch (ObjectNullException e) {
			e.printStackTrace();
		}catch(Exception e){
			request.setAttribute("msg", "发生未知错误，请联系管理员");
			String path = "error/error.jsp";
			request.getRequestDispatcher(path).forward(request, response);		
		}
		request.setAttribute("title", "教师信息查询");
		request.setAttribute("path", "teacherinfo.jsp");
		Object a1=request.getSession().getAttribute("account");		
	    request.setAttribute("a", a1);
		request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
	}
		else{
request.setAttribute("title", "教师信息管理");
request.setAttribute("path", "teacher.jsp");
Object a1=request.getSession().getAttribute("account");		
request.setAttribute("a", a1);
request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
		}
		
		
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
