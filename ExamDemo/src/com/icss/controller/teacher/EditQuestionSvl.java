package com.icss.controller.teacher;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.TeacherBiz;
import com.icss.entity.Tqt;
import com.icss.entity.Tquestion;
import com.icss.exception.ObjectNullException;

public class EditQuestionSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public EditQuestionSvl() {
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
		String qid = request.getParameter("qid");
		request.getSession().setAttribute("qid", qid);
		TeacherBiz biz = new TeacherBiz();
		
	
		try {	int qqid = Integer.valueOf(qid);
				Tquestion q = biz.queryques1(qqid);
				request.setAttribute("q", q);
				List<Tqt>  tqt = biz.queryqtid();	
				request.getSession().setAttribute("tqt", tqt);
				request.setAttribute("tqt", tqt);
				
		} catch (ObjectNullException e) {
			e.printStackTrace();
			}catch (Exception e) {
			request.setAttribute("msg", "发生未知错误，请联系管理员");
			String path = "error.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}
	
		request.setAttribute("title","知识点修改");
		request.setAttribute("path", "editquestion.jsp");
		Object a1=request.getSession().getAttribute("account");		
	    request.setAttribute("a", a1);
		request.getRequestDispatcher("teacher.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "";	
		Object qid=request.getSession().getAttribute("qid");
	
		String qtid =request.getParameter("qtid");
		String qcont =request.getParameter("qcont");
		String qans =request.getParameter("qans");
		String qexp =request.getParameter("qexp");
		String qurl =request.getParameter("qurl");
		String ispastdue =request.getParameter("ispastdue");
		String cont = new String(qcont.getBytes("iso-8859-1"),"GBK");
		String ans = new String(qans.getBytes("iso-8859-1"),"GBK");
		String exp = new String(qexp.getBytes("iso-8859-1"),"GBK");
		TeacherBiz biz=new TeacherBiz();
		Tquestion ques = new Tquestion();
	
		try {
			
			     int qqid=Integer.parseInt(String.valueOf(qid));
				 int qqtid = Integer.valueOf(qtid);	
				 int past = Integer.valueOf(ispastdue);
				 ques.setQid(qqid);
				 ques.setQtid(qqtid);
				 ques.setIspastdue(past);
	
			
		
				ques.setQcont(cont);
				ques.setQans(ans);
				ques.setQexp(exp);			
				ques.setQurl(qurl);
			
			    biz.editquestion(ques);	
		
	
			    List<Tqt> tqt = null;
				tqt = biz.queryqtid();					
				request.setAttribute("tqt", tqt);
				List<Tquestion> question = biz.queryallquestion();
				request.setAttribute("ques", question);
				
			   		 
    			request.setAttribute("path", "question.jsp");
    			Object a1=request.getSession().getAttribute("account");		
    		    request.setAttribute("a", a1);
    			request.getRequestDispatcher("teacher.jsp").forward(request, response);
              
			} catch (Exception e) {
				request.setAttribute("msg", "发生未知错误，请联系管理员");
				path = "error.jsp";
				request.getRequestDispatcher(path).forward(request, response);
			}

			
		 
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
