package com.icss.controller.teacher;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.TeacherBiz;

import com.icss.entity.Texam;

import com.icss.entity.Tstuanscom;
import com.icss.util.Log;

public class CorrectpaperSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public CorrectpaperSvl() {
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
		    try {
//				List<Tpaperinfo>  tp=  biz.querypaper();
//			     request.setAttribute("tp", tp);
//			    request.getSession().setAttribute("tpaper", tp);
			    List<Texam> exam=biz.queryexam();
			    request.setAttribute("exam", exam);	
			  request.getSession().setAttribute("texam", exam);
			
			     request.setAttribute("title", "阅卷");
		         request.setAttribute("path", "correctpaper.jsp");
				 Object a1=request.getSession().getAttribute("account");		
				  request.setAttribute("a", a1);
			     request.getRequestDispatcher("teacher.jsp").forward(request, response);
				
			} catch (SQLException e) {
				String msg="未知错误！请联系管理员！";
				request.setAttribute("msg", msg);
				Log.logger.error(e.getMessage());
				request.getRequestDispatcher("error.jsp").forward(request, response);	
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
		Object examid1=request.getSession().getAttribute("eid");
	      int examid=Integer.valueOf((String)examid1);
		Object ts1= request.getSession().getAttribute("ts");
		@SuppressWarnings("unchecked")
		List<Tstuanscom> ts=(List<Tstuanscom>)ts1;
		TeacherBiz biz=new TeacherBiz();
		
//		Object t=request.getSession().getAttribute("texam");
//		@SuppressWarnings("unchecked")
//		List<Texam> texam=(List<Texam>)t;	
//		
		
		int score=0;
		String x = null;
		try {
		for(Tstuanscom tt :ts){
			
			String a=String.valueOf(tt.getSno());
			x=a;
			String b1=String.valueOf(tt.getQid());
			String c1=request.getParameter(b1);
			int b=Integer.valueOf(b1); 
			int c=Integer.valueOf(c1);
		    
				biz.editscore(a, b, c);	
				score+=c;
		    }
//				for(Texam  te: texam){
//					int examid =te.getExamid();					
		    biz.addscore(x,examid,score);
				

			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		
		 
		     request.setAttribute("title", "提交成功");
		     request.setAttribute("msg", "分数提交成功！");
	         request.setAttribute("path", "suc.jsp");
	         Object a1=request.getSession().getAttribute("account");	
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
