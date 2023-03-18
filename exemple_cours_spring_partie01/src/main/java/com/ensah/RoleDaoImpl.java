package com.ensah;

import org.springframework.stereotype.Component;

//Nécessaire pour que Spring gere le cycle de vie des objets de cette classe
@Component
public class RoleDaoImpl implements RoleDao {

	// Constructeur
	public RoleDaoImpl() {

		System.out.println(" Instantiation de RoleDaoImpl");

	}

	public void testRoleDao() {
		System.out.println("Appel de la méthode  testRoleDao de RoleDaoImpl");

	}

}
