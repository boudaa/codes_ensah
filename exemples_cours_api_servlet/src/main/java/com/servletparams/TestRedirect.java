package com.servletparams;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class TestRedirect extends HttpServlet {
       
 
    public TestRedirect() {
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//request.getServletContext().getRequestDispatcher("/back/test").forward(request, response);
	
		response.sendRedirect("http://localhost:8080/exemples_cours_api_servlet/back/test");
	
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
