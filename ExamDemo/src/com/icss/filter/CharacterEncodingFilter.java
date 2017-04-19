package com.icss.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.util.Log;

public class CharacterEncodingFilter implements Filter{
	protected String encoding = null;
	
	
	
	public void destroy() {
		this.encoding = null;
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response =(HttpServletResponse)res;
		if(encoding != null){
			String mname = request.getMethod();
			//将此 String 与另一个 String 比较，不考虑大小写。
			if(mname.equalsIgnoreCase("GET")){
				@SuppressWarnings("rawtypes")
				Enumeration values = request.getParameterNames();
				while(values.hasMoreElements()){
					String value = values.nextElement().toString();
					String[] vs = request.getParameterValues(value);	
					for(int i = 0; i < vs.length; i++){
						try{
							vs[i] = new String(vs[i].getBytes("iso-8859-1"),encoding);
						}catch(Exception e){
							Log.logger.error(e.getMessage());
						}
					}	
				}
			}
		}
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("encoding");
		
	}

}
