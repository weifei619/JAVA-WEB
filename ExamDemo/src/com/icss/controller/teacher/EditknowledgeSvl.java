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
import com.icss.exception.ObjectNullException;

public class EditknowledgeSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public EditknowledgeSvl() {
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
		
		String kid = request.getParameter("kid");
		request.getSession().setAttribute("kid",kid);
		TeacherBiz biz = new TeacherBiz();
		
	
		try {
			if (kid!=null) {
				int kkid = Integer.valueOf(kid);
				Tknowledge k = biz.queryknowledge1(kkid);
				request.setAttribute("k", k);
				List<Tcourse>   cour = biz.querycno();					
				request.setAttribute("cour", cour);
			
			}
			
				
		} catch (ObjectNullException e) {
			e.printStackTrace();
			}catch (Exception e) {
			request.setAttribute("msg", "发生未知错误，请联系管理员");
			String path = "error/error.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}
	
		request.setAttribute("title","知识点修改");
		request.setAttribute("path", "editknowledge.jsp");
		Object a1=request.getSession().getAttribute("account");		
	    request.setAttribute("a", a1);
		request.getRequestDispatcher("teacher.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	     String qid=request.getParameter("qid");
		Object kid=request.getSession().getAttribute("kid");
	
		String cno=request.getParameter("cno");
		String kname1=request.getParameter("kname");
		String kname = new String(kname1.getBytes("iso-8859-1"),"GBK");
		TeacherBiz biz=new TeacherBiz();
		Tknowledge kno = new Tknowledge();
	
		try {
			   int kkid=Integer.parseInt(String.valueOf(kid));
		      
		       kno.setKid(kkid);
				kno.setCno(cno);
				kno.setKname(kname);
				biz.editknowledge(kno);	
				if(qid!=null && !qid.equals("")){
				int  qqid=Integer.valueOf(qid);
				biz.addqu(kkid, qqid);
				}			
			 	List<Tcourse> cour = null;
				cour = biz.querycno();					
				request.setAttribute("cour", cour);
				List<Tknowledge> knowledge = biz.queryallknowledge();
				request.setAttribute("kno1", knowledge);
				
			   		 
    			request.setAttribute("path", "knowledge.jsp");
    			Object a1=request.getSession().getAttribute("account");		
    		    request.setAttribute("a", a1);
    			request.getRequestDispatcher("teacher.jsp").forward(request, response);
              
			} catch (Exception e) {
				request.setAttribute("msg", "发生未知错误，请联系管理员");
			
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}

			
		 
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
