package com.icss.controller.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.StudentBiz;
import com.icss.entity.Taccount;

import com.icss.entity.Tstuansinfo;

public class CheckScoreSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public CheckScoreSvl() {
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
		
		Taccount user =  (Taccount) request.getSession().getAttribute("account");  
	    String sno=user.getUno();
		
		StudentBiz biz =new StudentBiz();
		
		try {
			
			List<Tstuansinfo>  ts = biz.querypaper(sno);
			request.setAttribute("ts", ts);
			request.setAttribute("title", "考生成绩");
			request.setAttribute("path", "score.jsp");
			Object a1 = request.getSession().getAttribute("account");
			request.setAttribute("a", a1);
			request.getRequestDispatcher("student.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("msg", "发生未知错误，请联系管理员");
			String path = "error.jsp";
			request.getRequestDispatcher(path).forward(request, response);;
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object a1 = request.getSession().getAttribute("account");
		Taccount account=(Taccount)a1;
		String sno=account.getUno();
		String pid1=request.getParameter("pid");
		int pid=Integer.valueOf(pid1);
		StudentBiz biz=new StudentBiz();
		try {
			int score=biz.queryscore(sno, pid);
			request.setAttribute("score", score);
			request.setAttribute("pid", pid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		request.setAttribute("title", "考生成绩");
		request.setAttribute("path", "scoreinfo.jsp");		
		request.setAttribute("a", a1);
		request.getRequestDispatcher("student.jsp").forward(request, response);
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
