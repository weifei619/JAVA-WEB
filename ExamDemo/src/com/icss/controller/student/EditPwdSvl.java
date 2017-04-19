package com.icss.controller.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.icss.biz.StudentBiz;
import com.icss.entity.Taccount;

public class EditPwdSvl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public EditPwdSvl() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title", "修改学生密码");
		request.setAttribute("path", "editpwd.jsp");
		Object a1 = request.getSession().getAttribute("account");
		request.setAttribute("a", a1);
		request.getRequestDispatcher("student.jsp").forward(request, response);
	    return;
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg = "";
		Taccount user = (Taccount) request.getSession().getAttribute("account");
		String no = user.getUno();
		StudentBiz biz = new StudentBiz();
		try {
			String newpwd = request.getParameter("newpwd");
			String newpwdAgain = request.getParameter("newpwdAgain");
			if (newpwd.equals(newpwdAgain)) {
				biz.eidtpwd(no, newpwd);
				msg = "密码修改成功";
				request.setAttribute("msg", msg);
				request.setAttribute("path", "success2.jsp");
			} else {
				msg = "两次输入不一样";
				request.setAttribute("msg", msg);
				request.setAttribute("path", "success1.jsp");
			}
			request.getRequestDispatcher("student.jsp").forward(request,
					response);
			return;
		} catch (Exception e) {
			msg = "未知错误发生，请联系管理员......";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
