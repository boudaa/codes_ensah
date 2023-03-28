package com.ensah.core.web;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

@WebFilter("/*")
public class WebTestFilter implements Filter {

  

	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("######## WebTestFilter Pre Execution");
		
		chain.doFilter(request, response);
		
		System.out.println("######## WebTestFilter Post Execution");

	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
