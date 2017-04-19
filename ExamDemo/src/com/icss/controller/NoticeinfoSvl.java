package com.icss.controller;

import java.io.IOException;


import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;



import com.icss.biz.AdminBiz;
import com.icss.entity.Tnotice;


public class NoticeinfoSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public NoticeinfoSvl() {
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

		AdminBiz biz=new AdminBiz();
		try {
			
		List<Tnotice> notice=biz.queryallnotice();
	   request.setAttribute("notice", notice);
		} catch (Exception e) {
			String msg = "未知错误发生，请联系管理员......";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
		
			
		request.setAttribute("title", "公告信息管理");
		request.setAttribute("path", "notice.jsp");
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

AdminBiz biz = new AdminBiz();
		
		try {
			List <Tnotice>  n= biz.queryallnotice();
			
			
			 if(n != null ){	
				 System.out.println(123);
					JSONArray  jsonArray = JSONArray.fromObject(n);
					System.out.println(123);
					response.setCharacterEncoding("utf-8");	
					response.getWriter().print(jsonArray.toString());
			    }	
			
		} catch (Exception e) {
			String msg = "未知错误发生，请联系管理员......";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("error/error.jsp").forward(request, response); 
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
