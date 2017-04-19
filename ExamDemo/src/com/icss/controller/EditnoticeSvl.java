package com.icss.controller;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.AdminBiz;
import com.icss.entity.Tnotice;

public class EditnoticeSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public EditnoticeSvl() {
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
		String nid1=request.getParameter("nid");
		request.getSession().setAttribute("nid", nid1);
		AdminBiz biz=new AdminBiz();
		int nid=Integer.valueOf(nid1);
		try {
			Tnotice notice=biz.querynotices(nid);
			request.setAttribute("n", notice);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("title", "公告信息编辑");
		request.setAttribute("path", "editnotice.jsp");
		Object a1=request.getSession().getAttribute("account");		
		request.setAttribute("a", a1);
		request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
		
		
		
		
		

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object nid1=request.getSession().getAttribute("nid");
		int nid=Integer.parseInt(String.valueOf(nid1));
        String ncont= request.getParameter("ncont");
        String cont = new String(ncont.getBytes("iso-8859-1"),"GBK");
         Tnotice notice=new Tnotice();
         notice.setNid(nid);
         notice.setNcont(cont);
         AdminBiz biz=new AdminBiz();
         try {
			biz.updatenotice(notice);
			List<Tnotice> n=biz.queryallnotice();
			   request.setAttribute("notice", n);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
     	request.setAttribute("title", "公告信息编辑");
		request.setAttribute("path", "notice.jsp");
		Object a1=request.getSession().getAttribute("account");		
		request.setAttribute("a", a1);
		request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
         
         
         
	
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
