package com.ensah.config;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//Configuration du Controleur frontal de Spring MVC

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/** Utilisé pour la journalisation */
	private Logger LOGGER = Logger.getLogger(getClass().getName());

	public DispatcherServletInitializer() {

		LOGGER.info(" DispatcherServletInitializer init...");
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
