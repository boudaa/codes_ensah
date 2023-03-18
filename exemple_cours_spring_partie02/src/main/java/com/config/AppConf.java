package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.ensah.IUserDao;
import com.ensah.IUserService;
import com.ensah.UserDaoImpl;
import com.ensah.UserServiceImpl;

@Configuration
@PropertySource("classpath:test.properties")
public class AppConf {

	public AppConf() {
		System.out.println("La classe AppConfig est instanciée");
	}

	@Bean
	public IUserDao getUserDao() {

		System.out.println("AppConfig-->getUserDao appelée");

		return new UserDaoImpl();
	}

	@Bean
	public IUserService getUserService() {

		System.out.println("AppConfig-->getUserService appelée");

		return new UserServiceImpl(getUserDao());
	}

}
