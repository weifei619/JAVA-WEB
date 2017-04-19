package com.icss.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.AdminBiz;
import com.icss.entity.Tclass;

public class AddClassSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public AddClassSvl() {
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
		request.setAttribute("title", "增加班级");
		request.setAttribute("path", "addclass.jsp");
		Object a1=request.getSession().getAttribute("account");		
	    request.setAttribute("a", a1);
		request.getRequestDispatcher("admin/admin.jsp").forward(request, response);

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "";
		String classno = request.getParameter("classno");
		String classname1=request.getParameter("classname");
		String isgraduate=request.getParameter("isgraduate");
		String classname= new String(classname1.getBytes("iso-8859-1"),"GBK");

		 Tclass cla = new Tclass();
		 try{
			 cla.setClassno(classno);
			 cla.setClassname(classname);
			 cla.setIsgraduate(isgraduate);
		
			AdminBiz biz=new AdminBiz();
			biz.classadd(cla);
			request.setAttribute("path", "class.jsp");
			request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
			
		 }catch(Exception e){
			 request.setAttribute("msg", "发生未知错误，请联系管理员");
				path = "error/error.jsp";
				request.getRequestDispatcher(path).forward(request, response);
		 }


	
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
