package com.icss.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationFilter1 implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		/**
		 * 1.如果你的访问路径带有LoginSvl， 那么认为当前处于登录页。
		 * 2.如果没带LoginSvl，那么需要获取Seesion中的user属性。
		 * 3.如果user属性为空，则认为没有登录想要访问其它页面，打回登录页。
		 * 4.如果有user对象，继续往下走。 
		 */
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response =(HttpServletResponse)res;
		String url = request. getRequestURL().toString();
		System.out.println(123);
		if(url.indexOf("LoginSvl") > 0){
			//处于登录页
			chain.doFilter(request, response);
		}
		else{
			//不处于登录页
			Object obj = request.getSession().getAttribute("account");
			
			if(obj == null){
				request.setAttribute("msg", "操作未被认可，请登录之后尝试.");
				request.getRequestDispatcher("LoginSvl").forward(request, response);
			}else{
				chain.doFilter(request, response);
			}
		}
		
		
		
		

	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
