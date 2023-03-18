package com.ensah.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.ensah.core.web.MyInterceptor1;
import com.ensah.core.web.MyInterceptor2;

//Configuration d'une application Spring MVC (@EnableWebMvc)
//Avec support des transactions (@EnableTransactionManagement)

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.ensah" })
public class AppConfig implements WebMvcConfigurer {

	/** Utilisé pour la journalisation */
	private Logger LOGGER = Logger.getLogger(getClass().getName());

	public AppConfig() {

		LOGGER.info(" configuration init...");
	}

	// Configuration du ViewResolver

	@Bean
	public ViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/view/");
		bean.setSuffix(".jsp");
		return bean;
	}

	// Configuration d'un intercepteur MyInterceptor
	@Bean
	MyInterceptor1 myInterceptor1() {
		return new MyInterceptor1();
	}

	// Configuration d'un intercepteur MyInterceptor
	@Bean
	MyInterceptor2 myInterceptor2() {
		return new MyInterceptor2();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(myInterceptor1());
		registry.addInterceptor(myInterceptor2());
	}

}