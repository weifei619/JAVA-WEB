package com.icss.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginoutSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginoutSvl() {
		super();
	}

	public void destroy() {
		super.destroy(); 
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//清除User
		request.getSession().invalidate();   //所有session都被清除了.
		//request.getSession().removeAttribute("user");
		//调回首页  MainSvl
		request.getRequestDispatcher("LoginSvl").forward(request, response);

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void init() throws ServletException {
		
	}

}
