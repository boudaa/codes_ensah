package com.ensah.core.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

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
