package com.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * 
 * @author T.BOUDAA
 *
 */
public class EntityManagerFactoryBuilder {

	private static EntityManagerFactory emf;

	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("com.ensah.gs_etudiants");

		}
		return emf;
	}

}
