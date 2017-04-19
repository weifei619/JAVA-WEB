package com.icss.controller;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.icss.biz.AdminBiz;
import com.icss.entity.Texam;

public class EditplanSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public EditplanSvl() {
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
    String examid1=request.getParameter("examid");
    request.getSession().setAttribute("editp", examid1);
    String pid1=request.getParameter("pid");
    request.getSession().setAttribute("editplan", pid1);
    int examid=Integer.valueOf(examid1);
    int pid=Integer.valueOf(pid1);
    AdminBiz biz=new AdminBiz();
   
		try {
			
		Texam exam=biz.queryexam(examid);
		request.setAttribute("exam",exam);
		
		} catch (Exception e) {
			request.setAttribute("msg", "发生未知错误，请联系管理员");
			String path = "error/error.jsp";
			request.getRequestDispatcher(path).forward(request, response);	
		}
		request.setAttribute("pid", pid);
		request.setAttribute("title", "考试信息编辑");
		request.setAttribute("path", "editplan.jsp");
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

		Texam exam=new Texam();
		AdminBiz biz=new AdminBiz();
		Object examid1=request.getSession().getAttribute("editp");
		int examid=Integer.valueOf((String)examid1);
		String begintime=request.getParameter("begintime");
		String endtime=request.getParameter("endtime");
		String title=request.getParameter("ename");
		String examtitle = new String(title.getBytes("iso-8859-1"),"GBK");
		String examtype=request.getParameter("etype");
		String ischeck=request.getParameter("eyue");
		
		String examstate=request.getParameter("econ");
		Object pid1=request.getSession().getAttribute("editplan");
		int pid=Integer.valueOf((String)pid1);
	
	try{
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");

	Date stime = begintime != "" ? sdf.parse(begintime) : null;

	Date etime= sdf.parse(endtime);
	exam.setExamid(examid);
	exam.setEtime(etime);
	exam.setStime(stime);
	exam.setPid(pid);
	exam.setExamtype(examtype);
	exam.setExamtitle(examtitle);
	if(ischeck.equals("1")){
		biz.changeischeck(examid);
	}
	exam.setIscheck(ischeck);
	exam.setExamstate(examstate);
	biz.editexamplan(exam);
	List<Texam> exam1=biz.queryallexam();
	request.setAttribute("exam",exam1);
	request.setAttribute("title", "考试信息编辑");
	request.setAttribute("path", "editexamplan.jsp");
	Object a1=request.getSession().getAttribute("account");		
	request.setAttribute("a", a1);
	request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
	} catch (Exception e) {
		String msg = "已考完不可编辑！";
		request.setAttribute("msg", msg);
		request.setAttribute("title", "考试信息编辑");
		request.setAttribute("path", "error.jsp");
		Object a1=request.getSession().getAttribute("account");		
		request.setAttribute("a", a1);
		request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
		
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
