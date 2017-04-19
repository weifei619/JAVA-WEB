package com.icss.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.AdminBiz;

import com.icss.entity.Texam;
import com.icss.entity.Tpaperinfo;

public class ExamplanSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public ExamplanSvl() {
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
			List<Tpaperinfo> tp=biz.querypaper();
			request.setAttribute("tp", tp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		request.setAttribute("title", "考试安排");
		request.setAttribute("path", "examplan.jsp");
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
		String epid=request.getParameter("epid");
		String begintime=request.getParameter("begintime");
		String endtime=request.getParameter("endtime");
		String title=request.getParameter("ename");
		String examtitle = new String(title.getBytes("iso-8859-1"),"GBK");
		String examtype=request.getParameter("etype");
		String ischeck=request.getParameter("eyue");
		String examstate=request.getParameter("econ");
		int pid=Integer.valueOf(epid);
	Texam exam=new Texam();
	AdminBiz biz=new AdminBiz();
	try{
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");

	Date stime = begintime != "" ? sdf.parse(begintime) : null;

	Date etime= sdf.parse(endtime);
	exam.setEtime(etime);
	exam.setStime(stime);
	exam.setPid(pid);
	exam.setExamtype(examtype);
	exam.setExamtitle(examtitle);
	exam.setIscheck(ischeck);
	exam.setExamstate(examstate);
	biz.addexamplan(exam);
	List<Texam> exam1=biz.queryallexam();
	request.setAttribute("exam",exam1);
	} catch (Exception e) {
		String msg = "未知错误发生，请联系管理员......";
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("error/error.jsp").forward(request, response);
}
	
		
	request.setAttribute("title", "考试信息编辑");
	request.setAttribute("path", "editexamplan.jsp");
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
