package com.icss.controller.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.TeacherBiz;
import com.icss.entity.Tcourse;
import com.icss.entity.Tknowledge;
import com.icss.util.Log;

public class KnowledgeinfoSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public KnowledgeinfoSvl() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TeacherBiz biz=new TeacherBiz();
   try {
	   List<Tcourse>   cour = biz.querycno();					
		request.setAttribute("cour", cour);
	request.setAttribute("title", "查询知识点");
	request.setAttribute("path", "knowledge.jsp");
	request.getSession().setAttribute("cour", cour);
	} catch (Exception e) {
	Log.logger.error(e.getMessage());
}	
   Object a1=request.getSession().getAttribute("account");		
   request.setAttribute("a", a1);
   request.getRequestDispatcher("teacher.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String cno=request.getParameter("cno");
		String kname1=request.getParameter("kname");
		String kname = new String(kname1.getBytes("iso-8859-1"),"GBK");
		List<Tknowledge> kno1=null;
			
			
			
		   TeacherBiz biz=new TeacherBiz();
		   try {
		if(kname!=null && !kname.equals("")){
			kno1 = biz.queryknowledge(cno,kname);
			request.setAttribute("kno1",kno1);
			
		
			Object cour=request.getSession().getAttribute("cour");
			request.setAttribute("cour",cour);
			request.setAttribute("path", "knowledgeinfo.jsp");
			Object a1=request.getSession().getAttribute("account");		
		    request.setAttribute("a", a1);
			request.getRequestDispatcher("teacher.jsp").forward(request, response);
		}else{
		         List<Tcourse>      cour = biz.querycno();
				
				List<Tknowledge> knowledge = biz.queryallknowledge();
				request.setAttribute("kno1", knowledge);
				request.setAttribute("cour", cour);
				
				request.setAttribute("title", "查询知识点");
				request.setAttribute("path", "knowledge.jsp");
				request.getSession().setAttribute("cour", knowledge);
				Object a1=request.getSession().getAttribute("account");		
			    request.setAttribute("a", a1);
			request.getRequestDispatcher("teacher.jsp").forward(request, response);
			
		}
		} catch (Exception e) {
			request.setAttribute("msg", "未知错误发生，请联系管理员......");
			String path="error/error.jsp";
			request.getRequestDispatcher(path).forward(request, response);
			
		}
		 
			}	
	

	public void init() throws ServletException {
		// Put your code here
	}

}
