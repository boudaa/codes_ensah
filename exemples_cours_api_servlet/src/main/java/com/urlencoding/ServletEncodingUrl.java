package com.urlencoding;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ServletEncodingUrl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		

		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session =  request.getSession();
	
		if(session.getAttribute("Test")!=null) {
			out.println("Existe dans la session<br>");
			out.println(session.getAttribute( "Test" ));
		}
		else {
			out.println("N'existe pas dans la session on l'ajoute");
			session.setAttribute("Test", "test");
			
		}
		
		
		String url = "ServletEncodingUrl";
		String encodedURL = response.encodeURL(url);
		
		out.println("<br>URL après encodage (Si les cookies sont bloqués vous allez remarquer l'ajout du session id dans l'url): "+ encodedURL );
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
