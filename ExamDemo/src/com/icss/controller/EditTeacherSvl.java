package com.icss.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.AdminBiz;
import com.icss.entity.Taccount;
import com.icss.entity.Tteacher;
import com.icss.exception.ObjectNullException;

public class EditTeacherSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Constructor of the object.
	 */
	public EditTeacherSvl() {
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
		String tno = request.getParameter("tno");
		request.getSession().setAttribute("admin", tno);
		AdminBiz biz = new AdminBiz();
		try {
			Tteacher t = biz.checkteacher(tno);
			Taccount a=biz.checkaccount(tno);
			request.setAttribute("t", t);
			request.setAttribute("a", a);
		} catch (ObjectNullException e) {
			e.printStackTrace();
		} catch (Exception e) {
			request.setAttribute("msg", "发生未知错误，请联系管理员");
			String path = "error/error.jsp";
			request.getRequestDispatcher(path).forward(request, response);	
		}
		request.setAttribute("title", "教师信息编辑");
		request.setAttribute("path", "editteacher.jsp");
		Object a1=request.getSession().getAttribute("account");		
	    request.setAttribute("a", a1);
		request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
		

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "";	
		Object t=request.getSession().getAttribute("admin");
		String tno=(String) t;
		String tname1=request.getParameter("tname");
		String tname= new String(tname1.getBytes("iso-8859-1"),"GBK");
		String tgender= request.getParameter("tgender");
		String tcontact = request.getParameter("tcontact");
		String temail = request.getParameter("temail");
		String ison = request.getParameter("ison");
		String pwd=request.getParameter("pwd");
		 Tteacher tea=new Tteacher();
		 
		 tea.setTno(tno);
		 tea.setTname(tname);
		 tea.setTgender(tgender);
		 tea.setTemail(temail);
		 tea.setTcontact(tcontact);
		 tea.setIson(ison);
	   
		 Taccount account=new Taccount();
			account.setUno(tno);
			account.setPassword(pwd);
			account.setRole(2);
		AdminBiz biz=new AdminBiz();
		try {
			    biz.editaccount(account);			 
            	biz.editteacher(tea);
		
    			request.setAttribute("path", "teacher.jsp");
    			request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
              
			} catch (Exception e) {
				request.setAttribute("msg", "发生未知错误，请联系管理员");
				path = "error/error.jsp";
				request.getRequestDispatcher(path).forward(request, response);
			}

		
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
