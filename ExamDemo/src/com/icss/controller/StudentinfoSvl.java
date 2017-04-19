package com.icss.controller;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.icss.biz.AdminBiz;


import com.icss.entity.Tstudent;
import com.icss.entity.TurnPage;





public class StudentinfoSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public StudentinfoSvl() {
		super();
	}


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
//        String page = request.getParameter("page");
//        TurnPage tp = new TurnPage();
//        AdminBiz biz=new AdminBiz();
//		if(page != null && !page.equals("")){
//			tp.CurrentPageNo = Integer.valueOf(page);
//		}
//		if(tp.CurrentPageNo <= 0)
//			tp.CurrentPageNo = 1;
//		try {
//			List<Tstudent>  s= biz.queryInfo(tp);
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//		request.setAttribute("RecordAllCount", tp.RecordAllCount);
//		request.setAttribute("PageAllCount", tp.PageAllCount);
//		request.setAttribute("CurrentPageNo", tp.CurrentPageNo);
//        
        
        
	    String page = request.getParameter("page");
        TurnPage tp = new TurnPage();
        AdminBiz biz=new AdminBiz();
		if(page != null && !page.equals("")){
			tp.CurrentPageNo = Integer.valueOf(page);
		}else{
			tp.CurrentPageNo=1;
		}
		if(tp.CurrentPageNo <= 0)
			tp.CurrentPageNo = 1;
		try {
			List<Tstudent>  s= biz.queryInfo(tp);
	request.getSession().setAttribute("student", s);
	request.setAttribute("RecordAllCount", tp.RecordAllCount);
	request.setAttribute("PageAllCount", tp.PageAllCount);
	request.setAttribute("CurrentPageNo", tp.CurrentPageNo);
	} catch (Exception e) {
			String msg = "未知错误发生，请联系管理员......";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
            return;		
	}   
		

request.setAttribute("title", "学生信息管理");
request.setAttribute("path", "student.jsp");
Object a1=request.getSession().getAttribute("account");		
request.setAttribute("a", a1);
request.getRequestDispatcher("admin/admin.jsp").forward(request, response);

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
		try {
			Object  s=request.getSession().getAttribute("student");
//			Object  tp1=request.getSession().getAttribute("tp");
//			 TurnPage tp=(TurnPage) tp1;
//		
//			request.setAttribute("RecordAllCount", tp.RecordAllCount);
//			request.setAttribute("PageAllCount", tp.PageAllCount);
//			request.setAttribute("CurrentPageNo", tp.CurrentPageNo);
		    if(s != null){
				JSONArray jsonArray = JSONArray.fromObject(s); 
				response.setCharacterEncoding("utf-8"); //GBK乱码
				response.getWriter().print(jsonArray.toString());
			
		    }	
		} catch (Exception e) {
			String msg = "未知错误发生，请联系管理员......";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		    return;
		}
		

	}


	public void init() throws ServletException {
		// Put your code here
	}

}
