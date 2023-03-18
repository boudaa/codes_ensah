package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


/**
 * Classe pour gérer les opérations CRUD sur un objet de type Etudiant
 * 
 * @author boudaa
 *
 */
public class HibernateGenericDaoImpl<T> {

	/** référence l'unique instance de Session Factory */
	private SessionFactory sf = null;
	
	private Class<T> boClass;

	/**
	 * Constructeur
	 */
	public HibernateGenericDaoImpl(Class<T> boClass) {
		sf = SessionFactoryBuilder.getSessionFactory();
		this.boClass = boClass;
	}

	/**
	 * Permet de persister l'objet passé en paramètre
	 * 
	 * @param obj objet à persister
	 */
	public void save(T obj) {

		Session session = null;
		Transaction tx = null;

		try {

			// on obtient une session
			session = sf.getCurrentSession();

			// On commence une transaction
			tx = session.beginTransaction();

			// on execute les opérations bases de données

			// enregistrer un étudiant dans la base de données
			session.save(obj);

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

	/**
	 * Méthode de mise à jour
	 * 
	 * @param obj
	 */
	public void update(T obj) {

		Session session = null;
		Transaction tx = null;
		try {

			// on obtient une session
			session = sf.getCurrentSession();

			// On commence une transaction
			tx = session.beginTransaction();

			// on execute les opérations bases de données
			session.update(obj);

			// On valide la transaction, ceci ferme également la session
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

	/**
	 * Méthode pour la suppression d'un étudiant
	 * 
	 * @param pId : identifiant de l'entité à supprimer
	 */

	public void delete(Long pId) {

		Session session = null;
		Transaction tx = null;
		try {

			// on obtient une session
			session = sf.getCurrentSession();

			// On commence une transaction
			tx = session.beginTransaction();

			// on execute les opérations bases de données

			// Avec Hibernate pour supprimer une entité, il faut d'abord la charger de la
			// base de données vers la session (toutes les opérations sur les objets se font
			// via la session)
			T obj = (T) session.get(boClass, pId);

			// L'objet qu'est attaché à la session est supprimé (il devient transitoire,
			// l'enregistement associé en base de données sera donc supprimé)
			session.delete(obj);

			// On valide la transaction, ceci ferme également la session si on la récupérer
			// avec getCurrentSession
			// si elle est récupéré par openSession dans ce cas il faut appeler close de la
			// session explicitement
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

	/**
	 * Méthode permettant de chercher une entité étudiant par son nom
	 * 
	 * @param pName
	 * @return
	 */
	public List<T> finByName(String pName) {
		Session session = null;
		Transaction tx = null;
		List<T> list = null;

		try {

			// on obtient une session
			session = sf.getCurrentSession();

			// On commence une transaction
			tx = session.beginTransaction();

			// on execute les opérations bases de données

			// Requete HQL paramétrée pour chercher un étudiant par son nom
			String hqlQuery = "from com.bo.T where nom=?0 ";

			// Préparer la requete
			Query<T> query = session.createQuery(hqlQuery);

			// definir le paramètre de la requete (le nom)
			query.setParameter(0, pName);

			// executer et récupérer les résultats sous forme d'une liste d'étudiants
			list = query.getResultList();

			// On valide la transaction, ceci ferme également la session
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

		return list;

	}

	/**
	 * Permet de récupérer toutes les entités enregistrées en base de données
	 * 
	 * @return
	 */
	public List<T> findAll() {
		Session session = null;
		Transaction tx = null;
		List<T> list = null;

		try {

			// on obtient une session
			session = sf.getCurrentSession();

			// On commence une transaction
			tx = session.beginTransaction();

			// on execute les opérations bases de données

			// Requete HQL paramétrée pour chercher un étudiant par son nom
			String hqlQuery = "from "+boClass.getName();

			// Préparer la requete
			Query<T> query = session.createQuery(hqlQuery);

			// executer et récupérer les résultats sous forme d'une litse d'étudiants
			list = query.getResultList();

			// On valide la transaction, ceci ferme également la session
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

		return list;

	}

	/**
	 * Permet de chercher une entité par son identifiant
	 * 
	 * @param pId
	 * @return
	 */
	public T findById(Long pId) {

		T obj = null;

		Session session = null;
		Transaction tx = null;
		List<T> list = null;

		try {

			// on obtient une session
			session = sf.getCurrentSession();

			// On commence une transaction
			tx = session.beginTransaction();

			// on execute les opérations bases de données

			// récupérer l'entité par son id
			obj = (T) session.get(boClass, pId);

			// On valide la transaction, ceci ferme également la session
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

		return obj;

	}

	public List<T> findByCriteria(String pClassName, String[] pColName, Object[] pColVal) {

		// On obtient la session en cours
		Session s = sf.getCurrentSession();

		List<T> list = new ArrayList<T>();

		Transaction tx = null;
		Session session = null;
		try {

			// On démarre une transaction localement
			tx = s.beginTransaction();

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < pColName.length; i++) {
				
				if(i==0) {
					sb.append(pColName[i] + "=?" + i);	
				}
				else {
					sb.append(" and " + pColName[i] + "=?" + i);
				}
				
			}

			Query<T> q = s.createQuery("from " + pClassName + " where " + sb , boClass);

			for (int i = 0; i < pColVal.length; i++) {

				q.setParameter(i, pColVal[i]);
			}

			list = q.list();

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

		return list;
	}

}
