package com.icss.controller.teacher;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.TeacherBiz;
import com.icss.entity.Taccount;
import com.icss.entity.Tcourse;
import com.icss.entity.Tpaperinfo;
public class AddtestSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public AddtestSvl() {
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
		TeacherBiz biz=new TeacherBiz();
		List<Tcourse> cour;
		try {
			cour = biz.querycno();
			request.setAttribute("cour", cour);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}					
	
	
		request.setAttribute("title", "添加试卷");
		request.setAttribute("path", "addtest.jsp");
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
Object a1=request.getSession().getAttribute("account");		
Taccount account=(Taccount) a1;
String tno=account.getUno();
String pid=request.getParameter("pid");
String  cno=request.getParameter("cno");
String  ptitle=request.getParameter("ptitle");
String  score=request.getParameter("score");
String pstate=request.getParameter("pstate");
System.out.println(tno);
Date date=new Date();
TeacherBiz biz=new TeacherBiz();
		if( pid !=null ){
			int pid1=Integer.valueOf(pid);
			int score1=Integer.valueOf(score);
			Tpaperinfo tp=new Tpaperinfo();
			tp.setPid(pid1);
			tp.setTno(tno);
			tp.setCno(cno);
			tp.setCtime(date);
			tp.setPtitle(ptitle);
			tp.setScore(score1);
			tp.setPstate(pstate);
			try {
				biz.addtest(tp);
			} catch (Exception e) {
				request.setAttribute("msg", "发生未知错误，请联系管理员");
				
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			
			
			
		}
			
			request.setAttribute("title", "添加试卷");
			request.setAttribute("path", "addtest.jsp");
		    request.setAttribute("a", a1);
			request.getRequestDispatcher("teacher.jsp").forward(request, response);
		
		
		
	



}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
