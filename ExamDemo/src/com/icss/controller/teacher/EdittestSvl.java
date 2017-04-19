package com.icss.controller.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.TeacherBiz;
import com.icss.entity.Tquestion;
public class EdittestSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public EdittestSvl() {
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
		String pid=request.getParameter("pid");
		request.getSession().setAttribute("paid", pid);
		
		
		String ptitle1=request.getParameter("ptitle");
		String ptitle = new String(ptitle1.getBytes("iso-8859-1"),"GBK");
		request.getSession().setAttribute("ptitle",ptitle);
		request.setAttribute("title","สิพํฃบ"+ptitle);
		request.setAttribute("path", "editpaperinfo.jsp");
		Object a1=request.getSession().getAttribute("account");		
	    request.setAttribute("a", a1);
		request.getRequestDispatcher("teacher.jsp").forward(request, response);
	
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

String kid=request.getParameter("kid");
String qtid=request.getParameter("qtid");
String ptitle=(String) request.getSession().getAttribute("ptitle");

TeacherBiz biz=new TeacherBiz();
try {
	List<Tquestion> question=biz.querytq(kid, qtid);
	request.setAttribute("question", question);
	
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
request.setAttribute("title","สิพํฃบ"+ptitle);
request.setAttribute("path", "editpaperinfo.jsp");
Object a1=request.getSession().getAttribute("account");		
request.setAttribute("a", a1);
request.getRequestDispatcher("teacher.jsp").forward(request, response);

	}

	}


