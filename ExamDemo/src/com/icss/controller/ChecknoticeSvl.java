package com.icss.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.AdminBiz;
import com.icss.entity.Tnotice;

public class ChecknoticeSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public ChecknoticeSvl() {
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

		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String beginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		AdminBiz biz=new AdminBiz();
		try {
			if ((beginDate != null && !beginDate.equals("")) || (endDate != null && !endDate.equals("")) ) {
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				Date bDate = beginDate != ""?sdf.parse(beginDate) : null;
				Date eDate = endDate != ""?sdf.parse(endDate) : null;
				List<Tnotice> notice=biz.querynotice(bDate,eDate);
		         request.setAttribute("notice", notice);
			}
		request.setAttribute("title", "公告信息管理");
		request.setAttribute("path", "notice.jsp");
		Object a1=request.getSession().getAttribute("account");		
		request.setAttribute("a", a1);
		request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
			}catch(Exception e){
				String msg = "未知错误发生，请联系管理员......";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("error/error.jsp").forward(request, response);
			
			}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
