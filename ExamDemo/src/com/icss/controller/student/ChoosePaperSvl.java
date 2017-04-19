package com.icss.controller.student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.StudentBiz;
import com.icss.entity.Tpaperinfo;

public class ChoosePaperSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChoosePaperSvl() {
		super();
	}

	
	public void destroy() {
		super.destroy(); 
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentBiz biz = new StudentBiz();
		List<Tpaperinfo> paperinfo;
		List<Tpaperinfo> paper=new ArrayList<Tpaperinfo>();
		
		try {	
			Date date=new Date();			
			paperinfo = biz.queryallpaper();
			for(Tpaperinfo t : paperinfo){
				if(t.getStime().compareTo(date)<0 && t.getEtime().compareTo(date)>=0){		
				paper.add(t);
				}
			}
			request.setAttribute("paperinfo", paper);
			request.setAttribute("title", "选择试卷");
			request.setAttribute("path", "paperinfo.jsp");
			Object a1 = request.getSession().getAttribute("account");
			request.setAttribute("a", a1);
			request.getRequestDispatcher("student.jsp").forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("msg", "发生未知错误，请联系管理员");
			String path = "error.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}

		

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
