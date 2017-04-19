package com.icss.controller.teacher;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.TeacherBiz;

import com.icss.entity.Tcourse;
import com.icss.entity.Tpaperinfo;

public class EditpaperSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public EditpaperSvl() {
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
request.getSession().setAttribute("pid", pid);
int pid1=Integer.valueOf(pid);
TeacherBiz biz=new TeacherBiz();
try {
	List<Tcourse> 	cour = biz.querycno();
		request.setAttribute("cour", cour);
	
	 Tpaperinfo  paperinfo= biz.querypaperinfos(pid1);
	  request.setAttribute("p", paperinfo);
	request.setAttribute("title", "查询试卷");
	request.setAttribute("path", "editpaperinfos.jsp");
	Object a1=request.getSession().getAttribute("account");		
    request.setAttribute("a", a1);
	request.getRequestDispatcher("teacher.jsp").forward(request, response);
	
} catch (SQLException e) {
	request.setAttribute("msg", "发生未知错误，请联系管理员");
	String path = "error.jsp";
	request.getRequestDispatcher(path).forward(request, response);
}catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		
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
		
		Object pid2= request.getSession().getAttribute("pid");
		String pid=(String) pid2;
	
		String  cno=request.getParameter("cno");
		String  ptitle1=request.getParameter("ptitle");
		String ptitle = new String(ptitle1.getBytes("iso-8859-1"),"GBK");
		String  score=request.getParameter("score");
		String pstate=request.getParameter("pstate");	
		Date date=new Date();
		TeacherBiz biz=new TeacherBiz();
				if( pid !=null ){
					int pid1=Integer.valueOf(pid);
					int score1=Integer.valueOf(score);
					Tpaperinfo tp=new Tpaperinfo();
					tp.setPid(pid1);
					tp.setCno(cno);
					tp.setCtime(date);
					tp.setPtitle(ptitle);
					tp.setScore(score1);
					tp.setPstate(pstate);
					try {
						biz.updatetest(tp);	
						List<Tpaperinfo>	paperinfo = biz.queryallpaper();
							request.setAttribute("paperinfo", paperinfo);
					} catch (Exception e) {
						request.setAttribute("msg", "发生未知错误，请联系管理员");
						
						request.getRequestDispatcher("error.jsp").forward(request, response);
					}
					
					
					
				}
				
				
				
				Object a1=	request.getSession().getAttribute("account");
					request.setAttribute("title", "查询试卷");
					request.setAttribute("path", "testinfo.jsp");
				    request.setAttribute("a", a1);
					request.getRequestDispatcher("teacher.jsp").forward(request, response);
				
		
	
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
