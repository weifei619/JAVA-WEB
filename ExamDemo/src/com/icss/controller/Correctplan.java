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
import com.icss.entity.Tteacher;

public class Correctplan extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public Correctplan() {
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
			
			List<Texam> exam=biz.querycorrecct();
			request.setAttribute("exam", exam);
			List<Tteacher> t = biz.queryallteacher();
			request.setAttribute("teacher", t);
		} catch (SQLException e) {
			 request.setAttribute("title", "´íÎó");
			    String msg="Î´Öª´íÎó£¡";
			    request.setAttribute("msg", msg);
		         request.setAttribute("path", "error.jsp");
				 Object a1=request.getSession().getAttribute("account");		
				  request.setAttribute("a", a1);
			     request.getRequestDispatcher("admin.jsp").forward(request, response);
		} catch (Exception e) {
			 request.setAttribute("title", "´íÎó");
			    String msg="Î´Öª´íÎó£¡";
			    request.setAttribute("msg", msg);
		         request.setAttribute("path", "error.jsp");
				 Object a1=request.getSession().getAttribute("account");		
				  request.setAttribute("a", a1);
			     request.getRequestDispatcher("admin.jsp").forward(request, response);
		}
		
		
		
		request.setAttribute("title", "ÔÄ¾í°²ÅÅ");
		request.setAttribute("path", "correctplan.jsp");
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
String examid1=request.getParameter("examid");
String tno=request.getParameter("tno");
int examid=Integer.valueOf(examid1);

AdminBiz biz=new AdminBiz();
try {

	biz.addtm(examid,tno);
	List<Texam> exam=biz.querycorrecct();
	request.setAttribute("exam", exam);
	List<Tteacher> t = biz.queryallteacher();
	request.setAttribute("teacher", t);
	request.setAttribute("msg", "Ìí¼Ó³É¹¦£¡");
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
request.setAttribute("title", "Ìí¼Ó³É¹¦");
request.setAttribute("path", "suc.jsp");
Object a1=request.getSession().getAttribute("account");		
request.setAttribute("a", a1);
request.getRequestDispatcher("admin/admin.jsp").forward(request, response);


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
