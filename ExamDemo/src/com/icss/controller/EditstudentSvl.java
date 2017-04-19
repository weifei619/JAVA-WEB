package com.icss.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.AdminBiz;
import com.icss.entity.Taccount;
import com.icss.entity.Tstudent;
import com.icss.exception.ObjectNullException;

public class EditstudentSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public EditstudentSvl() {
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
String sno=request.getParameter("sno");
request.getSession().setAttribute("admin", sno);
AdminBiz biz=new AdminBiz();

try {
	Tstudent s = biz.checkstudent(sno);
	Taccount a=biz.checkaccount(sno);
	request.setAttribute("s", s);
	request.setAttribute("a", a);
} catch (ObjectNullException e) {
	e.printStackTrace();
} catch (Exception e) {
	request.setAttribute("msg", "发生未知错误，请联系管理员");
	String path = "error/error.jsp";
	request.getRequestDispatcher(path).forward(request, response);	
}
request.setAttribute("title", "学生信息编辑");
request.setAttribute("path", "editstudent.jsp");
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
		String path = "";	
		Object s=request.getSession().getAttribute("admin");
		String sno=(String) s;
		String sname1=request.getParameter("sname");
		String sgender=request.getParameter("sgender");
		String scontact=request.getParameter("scontact");
		String semail=request.getParameter("semail");
		String classno=request.getParameter("classno");
		String saddress1=request.getParameter("saddress");
		String sgrade=request.getParameter("sgrade");
		String sage=request.getParameter("sage");
		String sschool1=request.getParameter("sschool");
		String pwd=request.getParameter("pwd");
		
		String sname = new String(sname1.getBytes("iso-8859-1"),"GBK");
		String saddress = new String(saddress1.getBytes("iso-8859-1"),"GBK");
		String sschool = new String(sschool1.getBytes("iso-8859-1"),"GBK");
		
	     Tstudent stu=new Tstudent();
	     int age=0;
			if (sage != null) {
					age = Integer.valueOf(sage);
				}
			
         stu.setSno(sno);
         stu.setClassno(classno);
         stu.setSaddress(saddress);
         stu.setSage(age);
         stu.setSemail(semail);
         stu.setScontact(scontact);
         stu.setSgender(sgender);
         stu.setSname(sname);
         stu.setSschool(sschool);
         stu.setSgrade(sgrade);
         
		
		
		Taccount account=new Taccount();
		account.setUno(sno);
		account.setPassword(pwd);
		account.setRole(3);
		AdminBiz biz=new AdminBiz();
		try {
			    biz.editaccount(account);			 
            	biz.editstudent(stu);
		
    			request.setAttribute("path", "student.jsp");
    			request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
              
			} catch (Exception e) {
				request.setAttribute("msg", "发生未知错误，请联系管理员");
				path = "error/error.jsp";
				request.getRequestDispatcher(path).forward(request, response);
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
