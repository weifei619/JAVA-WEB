package com.icss.controller.teacher;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.TeacherBiz;
import com.icss.entity.Tpaperinfo;


public class ChecktestSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public ChecktestSvl() {
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
		TeacherBiz biz=new TeacherBiz();
		List<Tpaperinfo> paperinfo;
		try {
			paperinfo = biz.queryallpaper();
			request.setAttribute("paperinfo", paperinfo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.setAttribute("title", "≤È—Ø ‘æÌ");
		request.setAttribute("path", "testinfo.jsp");
		Object a1=request.getSession().getAttribute("account");		
	    request.setAttribute("a", a1);
		request.getRequestDispatcher("teacher.jsp").forward(request, response);
		
	
		
		
		
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
		String ptitle=request.getParameter("ptitle");
       TeacherBiz biz=new TeacherBiz();
    
try {
	List<Tpaperinfo> paperinfo=biz.querypaperinfo(ptitle);
	request.setAttribute("paperinfo", paperinfo);
	
	request.setAttribute("title", " ‘æÌ–≈œ¢");
	request.setAttribute("path", "testinfo.jsp");
	Object a1=request.getSession().getAttribute("account");		
    request.setAttribute("a", a1);
	request.getRequestDispatcher("teacher.jsp").forward(request, response);
	

	
	
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
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
