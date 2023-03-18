package com.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.bo.Etudiant;
import com.bo.Personne;
import com.bo.Prof;
import com.dao.HibernateEtudiantDaoImpl;
import com.dao.HibernateProfDaoImpl;
import com.dao.SessionFactoryBuilder;

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

		Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();
		// Requete sur la super-classe Personne
		String hqlQuery = "from Personne ";

		Query<Etudiant> query = session.createQuery(hqlQuery);

		List<Etudiant> list = query.getResultList();

		tx.commit();

		for(Personne it :list) {
			System.out.println(it);
		}
		
	}
}
