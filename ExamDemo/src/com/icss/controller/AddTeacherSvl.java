package com.icss.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.AdminBiz;
import com.icss.entity.Taccount;
import com.icss.entity.Tteacher;

public class AddTeacherSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public AddTeacherSvl() {
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

		request.setAttribute("title", "增加学生账户");
		request.setAttribute("path", "addteacher.jsp");
		Object a1=request.getSession().getAttribute("account");		
	    request.setAttribute("a", a1);
		request.getRequestDispatcher("admin/admin.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "";
		String tno = request.getParameter("tno");
		String tname1=request.getParameter("tname");
		String tname= new String(tname1.getBytes("iso-8859-1"),"GBK");
		String tgender=request.getParameter("tgender");
		String temail=request.getParameter("temail");
		String tcontact=request.getParameter("tcontact");
		String ison=request.getParameter("ison");
		String pwd=request.getParameter("pwd");
		 Tteacher tea = new Tteacher();
		 try{
//		 int gender=0;
//			if (tgender != null) {
//				gender = Integer.valueOf(tgender);
//			}
//			int iso=0;
//			if (ison != null) {
//				iso = Integer.valueOf(ison);	
//			}
			tea.setTno(tno);
			tea.setTname(tname);
			tea.setTgender(tgender);
			tea.setTcontact(tcontact);
			tea.setTemail(temail);
			
			tea.setIson(ison);
			
			Taccount account=new Taccount();
			account.setUno(tno);
			account.setPassword(pwd);
			account.setRole(2);
		
			AdminBiz biz=new AdminBiz();
			
			biz.addaccount(account);
			biz.teacheradd(tea);
			request.setAttribute("path", "teacher.jsp");
			request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
			
		 }catch(Exception e){
			 request.setAttribute("msg", "发生未知错误，请联系管理员");
				path = "error/error.jsp";
				request.getRequestDispatcher(path).forward(request, response);
		 }

		
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
