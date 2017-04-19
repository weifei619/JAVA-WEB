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

public class KnowledgeAddSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Constructor of the object.
	 */
	public KnowledgeAddSvl() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Tcourse> cour = null;
		TeacherBiz biz = new TeacherBiz();
		try{
			cour = biz.querycno();
			request.setAttribute("cour", cour);
			
		request.setAttribute("title", "添加知识点");
		request.setAttribute("path", "knowledgeadd.jsp");
		request.getSession().setAttribute("cour", cour);
		}catch(Exception e){
			Log.logger.error(e.getMessage());
			
		}
		Object a1=request.getSession().getAttribute("account");		
	    request.setAttribute("a", a1);
		request.getRequestDispatcher("teacher.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String kid = request.getParameter("kid");
		String  cno=request.getParameter("cno");
		String  kname=request.getParameter("kname");
		String name = new String(kname.getBytes("iso-8859-1"),"GBK");
		
		 try{
			  int ckid=0;
				if (kid!= null) {
					ckid = Integer.valueOf(kid);	
				}

					TeacherBiz biz = new TeacherBiz();
					Tknowledge kno1 = new Tknowledge();
					
				kno1.setKid(ckid);
				 kno1.setCno(cno);
				 kno1.setKname(name);
				 
			    biz.addknowledge(kno1);
			    
			   
			    Object cour=request.getSession().getAttribute("cour");
				request.setAttribute("cour",cour);
				List<Tknowledge> knowledge = biz.queryallknowledge();
				request.setAttribute("kno1", knowledge);
				
				request.setAttribute("path", "knowledge.jsp");
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
