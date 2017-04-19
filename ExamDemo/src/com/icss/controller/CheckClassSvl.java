package com.icss.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.AdminBiz;
import com.icss.entity.Tclass;
import com.icss.exception.ObjectNullException;

public class CheckClassSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Constructor of the object.
	 */
	public CheckClassSvl() {
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
		String classno=request.getParameter("no");
		if(classno !=null && !classno.equals("")){
		AdminBiz biz=new AdminBiz();
		try{
			Tclass c = biz.checkclass(classno);
			request.setAttribute("c", c);
			
		}catch (ObjectNullException e) {
			e.printStackTrace();
		}catch(Exception e){
			request.setAttribute("msg", "发生未知错误，请联系管理员");
			String path = "error/error.jsp";
			request.getRequestDispatcher(path).forward(request, response);		
		}
		request.setAttribute("title", "班级信息查询");
		request.setAttribute("path", "classinfo.jsp");
		Object a1=request.getSession().getAttribute("account");		
	    request.setAttribute("a", a1);
		request.getRequestDispatcher("admin/admin.jsp").forward(request, response);	
	}
		else{
request.setAttribute("title", "班级信息管理");
request.setAttribute("path", "class.jsp");
Object a1=request.getSession().getAttribute("account");		
request.setAttribute("a", a1);
request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
}
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
