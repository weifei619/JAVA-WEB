package com.icss.controller;

import java.io.IOException;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.AdminBiz;
import com.icss.entity.Taccount;
import com.icss.entity.Tnotice;



public class NoticeaddSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public NoticeaddSvl() {
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
		 
     	request.setAttribute("title", "公告信息添加");
		request.setAttribute("path", "addnotice.jsp");
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
String nid1=request.getParameter("nid");
String ncont1=request.getParameter("ncont");
String ncont = new String(ncont1.getBytes("iso-8859-1"),"GBK");
Object account1=request.getSession().getAttribute("account");
Taccount account=(Taccount) account1;
String acc_id=account.getUno();
	Tnotice notice=new Tnotice();
	int nid=Integer.valueOf(nid1);
	
	Date date=new Date();

	
	notice.setAcc_id(acc_id);
	notice.setNid(nid);
	notice.setNcont(ncont);
	notice.setTime(date);
	AdminBiz biz=new AdminBiz();
	try {
		biz.addnotice(notice);
		
		List<Tnotice> n=biz.queryallnotice();
	   request.setAttribute("notice", n);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	request.setAttribute("title", "公告信息管理");
	request.setAttribute("path", "notice.jsp");
	Object a1=request.getSession().getAttribute("account");		
	request.setAttribute("a", a1);
	request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
     
	}

	}

