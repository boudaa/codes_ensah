package com.ensah;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MyServletTest")
public class MyServlet extends HttpServlet {

	public MyServlet() {

		System.out.println("La servlet est crée");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.print("<p>Bonjour <strong>Test</strong></p>");
		
		

		System.out.println("Je suis un GET");

		System.out.println("IP : " + request.getRemoteAddr());

		System.out.println(request.getParameter("nom"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Je suis un post");
		System.out.println("IP : " + request.getRemoteAddr());

		System.out.println(request.getParameter("nom"));

	}

}
