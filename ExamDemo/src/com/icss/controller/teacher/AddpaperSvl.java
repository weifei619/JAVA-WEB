package com.icss.controller.teacher;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.TeacherBiz;
import com.icss.entity.Tpaperties;

public class AddpaperSvl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public AddpaperSvl() {
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
		Object pid1=request.getSession().getAttribute("paid");
		String qid1=request.getParameter("cid");
		String score1=request.getParameter("score");
        String ti1=request.getParameter("ti");
        int pid=Integer.valueOf((String)pid1);
        int qid=Integer.valueOf(qid1);
        int score=Integer.valueOf(score1);
        int seq=Integer.valueOf(ti1);     
        Tpaperties tp=new Tpaperties();
        tp.setPid(pid);
        tp.setQid(qid);
        tp.setScore(score);
        tp.setSeq(seq);
        TeacherBiz biz=new TeacherBiz();
        try {
			biz.addpaper(tp);
		} catch (SQLException e) {
			request.setAttribute("msg", "发生未知错误，请联系管理员");
			
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}catch(Exception e){
		request.setAttribute("msg", "发生未知错误，请联系管理员");
		String path = "error.jsp";
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
