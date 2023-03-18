package com.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bo.Etudiant;
import com.bo.Prof;

/**
 * Classe pour gérer les opérations CRUD sur un objet de type Etudiant
 * 
 * @author boudaa
 *
 */
public class HibernateProfDaoImpl {

	/** référence l'unique instance de Session Factory */
	private SessionFactory sf = null;

	/**
	 * Constructeur
	 */
	public HibernateProfDaoImpl() {
		sf = SessionFactoryBuilder.getSessionFactory();
	}

	/**
	 * Permet de persister l'objet passé en paramètre
	 * 
	 * @param etd objet à persister
	 */
	public void save(Prof etd) {

		Session session = null;
		Transaction tx = null;

		try {

			// on obtient une session
			session = sf.getCurrentSession();

			// On commence une transaction
			tx = session.beginTransaction();

			// on execute les opérations bases de données

			// enregistrer un étudiant dans la base de données
			session.save(etd);

			// On valide la transaction, ceci ferme également la session si on l'a récupéré
			// avec getCurrentSession
			// si elle a été récupérée par openSession dans ce cas
			// il faut appeler la méthode close de la session explicitement
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
