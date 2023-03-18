package com.ensah.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.ensah.config.AppConfig;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	public DispatcherServletInitializer() {
		System.out.println("...DispatcherServletInitializer.........");
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






