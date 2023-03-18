package com.ensah;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;


public class UserServiceImpl implements IUserService {

	
	private IUserDao dao;
	
	@Value("${com.ensah.dbname}")
	private String dbName;
	

	public UserServiceImpl(IUserDao pDao) {
		System.out.println("La classe UserServiceImpl est bien instanciée");
		
		dao = pDao;
	}

	
	@PostConstruct
	public void initBean() {
		System.out.println("la méthode initBean  est applée");
	}
	
	@PreDestroy
	public void end() {
		System.out.println("la méthode end est applée ");
	}
	
	
	
	public void tester() {

		System.out.println("Méthode tester est applée");
		System.out.println("dbName= " +dbName);
		
		System.out.println("Le Dao est bien la = " + dao);
		dao.testerDao();

	}

}
