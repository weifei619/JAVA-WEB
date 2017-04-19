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
import com.icss.util.Log;

public class QuestionSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public QuestionSvl() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		TeacherBiz biz=new TeacherBiz();
		List<Tqt> tqt=null;
   try {
	   tqt=biz.queryqtid();
	   List<Tquestion> quest = biz.queryallquestion();
	request.setAttribute("ques", quest);
	request.setAttribute("tqt",tqt);
	request.setAttribute("title", "查询题目");
	request.setAttribute("path", "question.jsp");
	request.getSession().setAttribute("quest", quest);
	} catch (Exception e) {
	Log.logger.error(e.getMessage());
}	
   Object a1=request.getSession().getAttribute("account");		
   request.setAttribute("a", a1);
   request.getRequestDispatcher("teacher.jsp").forward(request, response);
   
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		String qtid=request.getParameter("qtid");
//		String qcont=request.getParameter("qcont");
//
//		List<Tquestion> ques=null;
//			
//			if (qtid != null) {
//				int qid = Integer.valueOf(qtid);
//			
//		   TeacherBiz biz=new TeacherBiz();
//		   try {
//		
//			ques=biz.queryquestion(qid, qcont);
//			request.setAttribute("ques", ques);
//			
//		
//			Object tqt=request.getSession().getAttribute("tqt");
//			request.setAttribute("tqt",tqt);
//			request.setAttribute("path", "question.jsp");
//			request.getRequestDispatcher("teacher.jsp").forward(request, response);
//		} catch (Exception e) {
//			request.setAttribute("msg", "未知错误发生，请联系管理员......");
//			String path="error/error.jsp";
//			request.getRequestDispatcher(path).forward(request, response);
//			
//		}
//		 
//			}	
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
