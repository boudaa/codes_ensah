package com.test;

import java.util.List;

import com.bo.Etudiant;
import com.dao.JPAEtudiantDaoImpl;

public class TestProgram {
	public static void main(String[] args) {

		JPAEtudiantDaoImpl dao = new JPAEtudiantDaoImpl();

		// Création de deux objets Etudiant tansitoires
		Etudiant etd1 = new Etudiant();
		etd1.setNom("boudaa");
		etd1.setPrenom("Mohamed");
		etd1.setCin("A11111");

		dao.save(etd1);

		List<Etudiant> list = dao.findAll();

		for (Etudiant it : list) {
			System.out.println(it);
		}
		list = dao.finByName("boudaa");

		for (Etudiant it : list) {
			System.out.println(it);
		}

	}
}
