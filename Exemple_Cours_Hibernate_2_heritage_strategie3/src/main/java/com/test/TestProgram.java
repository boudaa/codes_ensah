package com.test;

import com.bo.Etudiant;
import com.bo.Prof;
import com.dao.HibernateEtudiantDaoImpl;
import com.dao.HibernateProfDaoImpl;

public class TestProgram {
	public static void main(String[] args) {

		HibernateEtudiantDaoImpl dao = new HibernateEtudiantDaoImpl();
		HibernateProfDaoImpl pdao = new HibernateProfDaoImpl();

		Etudiant etd = new Etudiant();
		etd.setNom("boudaa");
		etd.setPrenom("Mohamed");
		etd.setCne("A11112");
		
		Prof prof = new Prof();
		prof.setNom("boudaa");
		prof.setPrenom("Mohamed");
		prof.setCin("A11111");

		dao.save(etd);
		pdao.save(prof);
	}
}
