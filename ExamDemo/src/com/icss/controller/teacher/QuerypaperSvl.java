package com.icss.controller.teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.TeacherBiz;
import com.icss.entity.Taccount;
import com.icss.entity.Texam;
import com.icss.entity.Tstuanscom;

public class QuerypaperSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public QuerypaperSvl() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
		 TeacherBiz biz=new TeacherBiz();
	       try {
	    	   Object a1=request.getSession().getAttribute("account");
	    	   Taccount account=(Taccount)a1;
	    	   String tno=account.getUno();	    	   
	    	   String examid1=request.getParameter("examid");
               request.getSession().setAttribute("eid", examid1);
                  int examid=Integer.valueOf(examid1); 
                  if(biz.check(tno,examid)){
						List<Tstuanscom> ts=biz.querytst(examid);
						request.setAttribute("ts", ts);                    	
						request.getSession().setAttribute("ts", ts);
						
						   List<Texam> exam=biz.queryexam();
						   request.setAttribute("exam", exam);	
						  
                  }
					     request.setAttribute("title", "阅卷");
				         request.setAttribute("path", "correctpaper.jsp");
								
						  request.setAttribute("a", a1);
					     request.getRequestDispatcher("teacher.jsp").forward(request, response);
						
					} catch (SQLException e) {
					    request.setAttribute("title", "错误");
					    String msg="未知错误！请联系管理员 ";
					    request.setAttribute("msg", msg);
				         request.setAttribute("path", "error.jsp");
						 Object a1=request.getSession().getAttribute("account");		
						  request.setAttribute("a", a1);
					     request.getRequestDispatcher("teacher.jsp").forward(request, response);	
					}catch (Exception e) {
						 request.setAttribute("title", "错误");
						    String msg="！无阅卷权限";
						    request.setAttribute("msg", msg);
					         request.setAttribute("path", "error.jsp");
							 Object a1=request.getSession().getAttribute("account");		
							  request.setAttribute("a", a1);
						     request.getRequestDispatcher("teacher.jsp").forward(request, response);	
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
