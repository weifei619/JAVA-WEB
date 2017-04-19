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

public class QuestionAddSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public QuestionAddSvl() {
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
		
		TeacherBiz biz = new TeacherBiz();
		try {
			List<Tqt> tqt =biz.queryqtid();
			request.getSession().setAttribute("tqt", tqt);
			request.setAttribute("tqt", tqt);
		} catch (Exception e) {
			request.setAttribute("msg", "发生未知错误，请联系管理员");
			String path = "error.jsp";
			request.getRequestDispatcher(path).forward(request, response);
			
		}
		request.setAttribute("title", "添加知识点");
		request.setAttribute("path", "questionadd.jsp");
		Object a1=request.getSession().getAttribute("account");		
	    request.setAttribute("a", a1);
		request.getRequestDispatcher("teacher.jsp").forward(request, response);

		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String  qid = request.getParameter("qid");
		String  qtid=request.getParameter("qtid");
		String  qans=request.getParameter("qans");
		String  qcont=request.getParameter("qcont");
		String  qexp=request.getParameter("qexp");
		String cont = new String(qcont.getBytes("iso-8859-1"),"GBK");
		String ans = new String(qans.getBytes("iso-8859-1"),"GBK");
		String exp = new String(qexp.getBytes("iso-8859-1"),"GBK");
		String  qurl=request.getParameter("qurl");
		String  ispastdue=request.getParameter("ispastdue");
		TeacherBiz biz = new TeacherBiz();
					Tquestion ques = new Tquestion();
		 try{
			 if(qid != null && qtid!=null){
					 int cqid = Integer.valueOf(qid);
					 int cqtid = Integer.valueOf(qtid);	
					 int past = Integer.valueOf(ispastdue);
					 ques.setQid(cqid);
					 ques.setQtid(cqtid);
					 ques.setIspastdue(past);
			 }
					
				
				
				ques.setQcont(cont);
				ques.setQans(ans);
				ques.setQexp(exp);
				
				ques.setQurl(qurl);
			 
			    biz.addquestion(ques);
			
			    Object tqt=request.getSession().getAttribute("tqt");
				request.setAttribute("tqt",tqt);
				List<Tquestion> question = biz.queryallquestion();
				request.setAttribute("ques", question);
				request.setAttribute("title", "查询题目");
				request.setAttribute("path", "question.jsp");
				Object a1=request.getSession().getAttribute("account");		
			    request.setAttribute("a", a1);
				request.getRequestDispatcher("teacher.jsp").forward(request, response);
			      } catch (Exception e) {
			    	  request.setAttribute("msg", "未知错误发生，请联系管理员......");
						String path="error.jsp";
						request.getRequestDispatcher(path).forward(request, response);
			   
			      }
	
	}

	

	public void init() throws ServletException {
		// Put your code here
	}

}
