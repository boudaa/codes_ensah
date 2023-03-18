package com.ensah;

import org.springframework.stereotype.Component;

//Cette annotation nécessaire pour que Spring gere le cycle de vie des objets de cette classes (lea beans)
@Component
public class UserDaoImpl implements UserDao {

	// Constructeur
	public UserDaoImpl() {

		System.out.println(" Instantiation de UserDaoImpl");

	}

	public void testUserDao() {
		System.out.println("Appel de la méthode  testUserDao de UserDaoImpl");

	}

}
