package com.icss.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.AdminBiz;
import com.icss.entity.Taccount;
import com.icss.entity.Tclass;
import com.icss.entity.Tstudent;

public class AddstudentSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public AddstudentSvl() {
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
		AdminBiz biz=new AdminBiz();
		List<Tclass> tclass;
		try {
			tclass = biz.queryallclass();
			request.setAttribute("tclass", tclass);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		request.setAttribute("title", "增加学生账户");
		request.setAttribute("path", "addstudent.jsp");
		Object a1=request.getSession().getAttribute("account");		
	    request.setAttribute("a", a1);
		request.getRequestDispatcher("admin/admin.jsp").forward(request, response);

		
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//		out.println("<HTML>");
//		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//		out.println("  <BODY>");
//		out.print("    This is ");
//		out.print(this.getClass());
//		out.println(", using the GET method");
//		out.println("  </BODY>");
//		out.println("</HTML>");
//		out.flush();
//		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "";	
		String sno=request.getParameter("sno");
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
			    biz.addaccount(account);			 
            	biz.studentadd(stu); 	
            	request.setAttribute("msg", "添加学生账户成功");
    			request.setAttribute("path", "addsuc.jsp");
    			request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
              
			} catch (Exception e) {
				request.setAttribute("msg", "发生未知错误，请联系管理员");
				path = "error/error.jsp";
				request.getRequestDispatcher(path).forward(request, response);
			}
		
		}
//
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//		out.println("<HTML>");
//		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//		out.println("  <BODY>");
//		out.print("    This is ");
//		out.print(this.getClass());
//		out.println(", using the POST method");
//		out.println("  </BODY>");
//		out.println("</HTML>");
//		out.flush();
//		out.close();
	//}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
