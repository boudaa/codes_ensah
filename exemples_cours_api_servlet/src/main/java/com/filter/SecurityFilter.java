package com.filter;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class SecurityFilter implements Filter {

	private static Logger LOGGER;


	public SecurityFilter() {

		LOGGER = Logger.getLogger(getClass());

		LOGGER.info("Filter security est crée");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		LOGGER.info("security filter est appelé..");

		HttpServletRequest rq = (HttpServletRequest) request;

		// On récupère la session

		HttpSession session = rq.getSession();

		if (session.getAttribute("user") == null) {

			rq.getRequestDispatcher("/connexion.jsp").forward(request, response);

		} else {
			chain.doFilter(request, response);

		}

		LOGGER.info("fin d'execution de security filter ..");

	}

}
