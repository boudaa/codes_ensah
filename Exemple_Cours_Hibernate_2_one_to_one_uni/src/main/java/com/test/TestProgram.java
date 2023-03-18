package com.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.bo.Adresse;
import com.bo.Etudiant;
import com.dao.SessionFactoryBuilder;

public class TestProgram {
	private static final SessionFactory sf = SessionFactoryBuilder.getSessionFactory();

	/**
	 * Dans ce programme dans une première session: on crée des étudiants on leur
	 * affecte des adresses puis on sauvegarde ces étudiants dans la base de
	 * données. Dans une deuxième session : on recharge l'étudiant de la base de
	 * données et on supprime sa relation l'adresse. Dans une troisième session : on
	 * recharge de la base de données l'étudiant et on vérifie que l'étudiant n'a
	 * plus d'adresse
	 */
	public static void main(String[] args) {

		Session session = null;
		Transaction tx = null;

		// Création des objets
		Etudiant etd1 = new Etudiant();
		etd1.setNom("boudaa");
		etd1.setPrenom("Mohamed");
		etd1.setCin("A11111");

		Etudiant etd2 = new Etudiant();
		etd2.setNom("Karami");
		etd2.setPrenom("Ali");
		etd2.setCin("A15825");

		Adresse ad0 = new Adresse();
		ad0.setVille("Al Hoceima");

		Adresse ad1 = new Adresse();
		ad1.setVille("Imzouren");

		Adresse ad2 = new Adresse();
		ad2.setVille("Tanger");

		Adresse ad3 = new Adresse();
		ad3.setVille("Nador");

		// Affecter des adresses
		etd1.setAdresse(ad0);
		etd2.setAdresse(ad1);

		System.out.println("########################## SESSION 1 #############################");

		try {

			// on obtient une session
			session = sf.getCurrentSession();

			// On commence une transaction
			tx = session.beginTransaction();

			// Enregistrer l'étudiants et ses adresses associées
			session.persist(etd1); // Attention si on utilise la méthode save (propre à Hibernate) à la place de
									// persist
									// CascadeType.PERSIST ne propagera pas l'opération de persistance aux entités
									// composites.

			System.out.println("----Affichage de tous les étudiants ajoutés en base de données----");

			Query<Etudiant> query = session.createQuery("from com.bo.Etudiant");
			List<Etudiant> list = query.getResultList();

			for (Etudiant it : list) {
				System.out.println(it);
			}

			// On valide la transaction. La session sera fermée
			tx.commit();

		} catch (HibernateException ex) {

			// Si il y a des problèmes et une transaction a été déjà crée on l'annule
			if (tx != null) {
				// Annulation d'une transaction
				tx.rollback();

			}

			// On n'oublie pas de remonter l'erreur originale
			throw ex;

		} finally {

			// Si la session n'est pas encore fermée par commit
			if (session != null && session.isOpen()) {
				session.close();
			}

		}

		// Nouvelle session
		System.out.println("########################## SESSION 2 #############################");

		try {

			// on obtient une nouvelle session
			session = sf.getCurrentSession();

			// On commence une transaction
			tx = session.beginTransaction();

			// On recharge l'étudiant de la base de données
			Etudiant etd = session.get(Etudiant.class, etd1.getId());
			System.out.println(
					"Nombre d'adresses de l'étudiant avant suppression = " + (etd.getAdresse() == null ? 0 : 1));

			// Supprimer l'une de ses adresses.
			System.out.println("Suppresion d'une adresse de la liste des adresse de l'étudiant");

			etd.setAdresse(null);

			tx.commit();

		} catch (HibernateException ex) {

			// Si il y a des problèmes et une transaction a été déjà crée on l'annule
			if (tx != null) {
				// Annulation d'une transaction
				tx.rollback();

			}

			// On n'oublie pas de remonter l'erreur originale
			throw ex;

		} finally {

			// Si la session n'est pas encore fermée par commit
			if (session != null && session.isOpen()) {
				session.close();
			}

		}

		// Nouvelle session
		System.out.println("########################## SESSION 3 #############################");

		try {

			// on obtient une nouvelle session
			session = sf.getCurrentSession();

			// On commence une transaction
			tx = session.beginTransaction();

			// On recharge l'étudiant de la base de données
			Etudiant etd = session.get(Etudiant.class, etd1.getId());

			System.out.println(
					"Nombre d'adresses de l'étudiant après suppression = " + (etd.getAdresse() == null ? 0 : 1));

			System.out.println("----Affichage de tous les étudiants ajoutés en base de données----");

			Query<Etudiant> query = session.createQuery("from com.bo.Etudiant");
			List<Etudiant> list = query.getResultList();

			for (Etudiant it : list) {
				System.out.println(it);
			}

			System.out.println("----Affichage de toutes les adresses ajoutés en base de données----");
			Query<Adresse> queryAdd = session.createQuery("from com.bo.Adresse");
			List<Adresse> listAdd = queryAdd.getResultList();

			for (Adresse it : listAdd) {
				System.out.println(it);
			}

			tx.commit();

		} catch (HibernateException ex) {

			// Si il y a des problèmes et une transaction a été déjà crée on l'annule
			if (tx != null) {
				// Annulation d'une transaction
				tx.rollback();

			}

			// On n'oublie pas de remonter l'erreur originale
			throw ex;

		} finally {

			// Si la session n'est pas encore fermée par commit
			if (session != null && session.isOpen()) {
				session.close();
			}

		}

	}
}
