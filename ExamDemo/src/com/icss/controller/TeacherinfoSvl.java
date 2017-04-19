package com.icss.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.icss.biz.AdminBiz;
import com.icss.entity.Tteacher;






public class TeacherinfoSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public TeacherinfoSvl() {
		super();
	}


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

request.setAttribute("title", "教师信息管理");
request.setAttribute("path", "teacher.jsp");
Object a1=request.getSession().getAttribute("account");		
request.setAttribute("a", a1);
request.getRequestDispatcher("admin/admin.jsp").forward(request, response);

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminBiz biz = new AdminBiz();
		
		try {
			List<Tteacher> t = biz.queryallteacher();
			 if(t != null){
					JSONArray jsonArray = JSONArray.fromObject(t); 
					response.setCharacterEncoding("utf-8"); //GBK乱码
					response.getWriter().print(jsonArray.toString());
			    }	
			
		} catch (Exception e) {
			String msg = "未知错误发生，请联系管理员......";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("error/error.jsp").forward(request, response); 
		}
		
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
