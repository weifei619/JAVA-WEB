package com.icss.controller.student;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.ExamBiz;
import com.icss.biz.StudentBiz;
import com.icss.entity.Taccount;
import com.icss.entity.Tpaperties;


public class ExamSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public ExamSvl() {
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
		String examid1=request.getParameter("examid");
		request.getSession().setAttribute("examid", examid1);
		
		String pid1=request.getParameter("pid");
		request.getSession().setAttribute("ppid", pid1);
		int pid=Integer.valueOf(pid1);
		int examid=Integer.valueOf((String)examid1);
		Taccount account = (Taccount) request.getSession().getAttribute("account");
		String sno = account.getUno();
		request.setAttribute("a", account);
		ExamBiz biz = new ExamBiz();
		StudentBiz sbiz=new StudentBiz();
		try {
			
			if(sbiz.querypids(sno)!=examid){			
			sbiz.addtstuansinfo(examid,sno);
			}				
			List<Tpaperties> choices = biz.queryBychioce(pid);
			request.setAttribute("choices", choices);
			request.getSession().setAttribute("choices", choices);
			List<Tpaperties> completion = biz.queryBycompletion(pid);
			request.setAttribute("completions", completion);
			request.getSession().setAttribute("completions", completion);
			List<Tpaperties> judge = biz.queryByjudge(pid);
			request.setAttribute("judges", judge);
			request.getSession().setAttribute("judges", judge);
			List<Tpaperties> answer = biz.queryByanswer(pid);
			request.setAttribute("answers", answer);
			request.getSession().setAttribute("answers", answer);
			List<Tpaperties> application = biz.queryByapplication(pid);
			request.setAttribute("applications", application);
			request.getSession().setAttribute("applications", application);

			request.setAttribute("title", "在线考试");
			request.setAttribute("path", "testpaper.jsp");
			Object a1=request.getSession().getAttribute("account");		
		    request.setAttribute("a", a1);
			request.getRequestDispatcher("student.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("title", "提示！");
			request.setAttribute("msg","已答过试卷！");
			request.setAttribute("path", "suc.jsp");
			request.getRequestDispatcher("student.jsp").forward(request, response);
		}


	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentBiz biz=new StudentBiz();
		request.setAttribute("msg","提交试卷成功");
		request.setAttribute("path", "suc.jsp");
		Object examid1= request.getSession().getAttribute("examid");
		int examid=Integer.valueOf((String)examid1);
//		
//		Object ppid = request.getSession().getAttribute("ppid");
//		int pid=Integer.valueOf((String)ppid);
	
		Taccount account = (Taccount) request.getSession().getAttribute("account");
		String sno = account.getUno();
		request.setAttribute("a", account);
		int pid=0;
		try {
			pid = biz.querypid(sno,examid);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
//	
//		try {
//		
//					biz.addtstuansinfo(pid,examid,sno);	
//				
//			
//					
//		} catch (Exception e1) {
//			request.setAttribute("msg","已提交过答卷！");
//			request.setAttribute("path", "suc.jsp");
//			
//		}
		@SuppressWarnings("unchecked")
		List<Tpaperties> c1 = (List<Tpaperties>) request.getSession().getAttribute("choices");
		@SuppressWarnings("unchecked")
		List<Tpaperties> co = (List<Tpaperties>) request.getSession().getAttribute("completions");
		@SuppressWarnings("unchecked")
		List<Tpaperties>  ju = (List<Tpaperties>) request.getSession().getAttribute("judges");
		@SuppressWarnings("unchecked")
		List<Tpaperties> an = (List<Tpaperties>) request.getSession().getAttribute("answers");
		@SuppressWarnings("unchecked")
		List<Tpaperties> ap = (List<Tpaperties>) request.getSession().getAttribute("applications");

		for (Tpaperties c : c1) {
			String q= String.valueOf(c.getQid());
			String qan= request.getParameter(q);
			try {
				int qid=Integer.valueOf(q);				
			    biz.addts(pid, qid, qan);
			} catch (Exception e) {
				request.setAttribute("msg","提交试卷成功");
				request.setAttribute("path", "suc.jsp");
				
			}
		}
		
		for (Tpaperties c : co) {
			String q= String.valueOf(c.getQid());
			String b= request.getParameter(q);
			try {
				String qan= "";
				if(b != null && !b.equals("")){
				 qan= new String(b.getBytes("iso-8859-1"),"GBK");
				}
				int qid=Integer.valueOf(q);				
			    biz.addts(pid, qid, qan);
			} catch (Exception e) {
				request.setAttribute("msg","提交试卷成功");
				request.setAttribute("path", "suc.jsp");
				
			}
		}
		
		for (Tpaperties c : ju) {
			String q= String.valueOf(c.getQid());
			String b= request.getParameter(q);
			try {
				String qan= "";
				if(b != null && !b.equals("")){
				 qan= new String(b.getBytes("iso-8859-1"),"GBK");
				}
				int qid=Integer.valueOf(q);				
			    biz.addts(pid, qid, qan);
			} catch (Exception e) {
				request.setAttribute("msg","提交试卷成功");
				request.setAttribute("path", "suc.jsp");
			}
		}
		for (Tpaperties c : an) {
			String q= String.valueOf(c.getQid());
			String b= request.getParameter(q);
			try {
				String qan= "";
				if(b != null && !b.equals("")){
				 qan= new String(b.getBytes("iso-8859-1"),"GBK");
				}
				int qid=Integer.valueOf(q);				
			    biz.addts(pid, qid, qan);
			} catch (Exception e) {
				request.setAttribute("msg","提交试卷成功");
				request.setAttribute("path", "suc.jsp");
				
				
			}
		}
		for (Tpaperties c : ap) {
			String q= String.valueOf(c.getQid());
			String b= request.getParameter(q);
			try {
				String qan= "";
				if(b != null && !b.equals("")){
				 qan= new String(b.getBytes("iso-8859-1"),"GBK");
				}
				int qid=Integer.valueOf(q);				
			    biz.addts(pid, qid, qan);
			} catch (Exception e) {
				request.setAttribute("msg","提交试卷成功");
				request.setAttribute("path", "suc.jsp");
			}
		}
		
		
		request.getRequestDispatcher("student.jsp").forward(request, response);
		
		
		
		
		
		
	}

	public void init() throws ServletException {

	}

}
