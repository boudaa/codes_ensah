package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.bo.Etudiant;

/**
 * Classe pour gérer les opérations CRUD sur un objet de type Etudiant
 * 
 * @author boudaa
 *
 */
public class JPAEtudiantDaoImpl {

	/** référence l'unique instance de em Factory */
	private EntityManagerFactory emf = null;

	/**
	 * Constructeur
	 */
	public JPAEtudiantDaoImpl() {
		emf = EntityManagerFactoryBuilder.getEntityManagerFactory();
	}

	/**
	 * Permet de persister l'objet passé en paramètre
	 * 
	 * @param etd objet à persister
	 */
	public void save(Etudiant etd) {

		EntityManager em = null;
		EntityTransaction tx = null;

		try {

			// on obtient une em
			em = emf.createEntityManager();

			// On commence une transaction
			tx = em.getTransaction();
			tx.begin();
			// on execute les opérations bases de données

			// enregistrer un étudiant dans la base de données
			em.persist(etd);

			// On valide la transaction, ceci ferme également la em si on l'a récupéré
			// avec getCurrentem
			// si elle a été récupérée par openem dans ce cas
			// il faut appeler la méthode close de la em explicitement
			tx.commit();

		} catch (Exception ex) {

			// Si il y a des problèmes et une transaction a été déjà crée on l'annule
			if (tx != null) {
				// Annulation d'une transaction
				tx.rollback();

			}

			// On n'oublie pas de remonter l'erreur originale
			throw ex;

		} finally {

			// Si la em n'est pas encore fermée par commit
			if (em != null && em.isOpen()) {
				em.close();
			}

		}

	}

	/**
	 * Méthode de mise à jour
	 * 
	 * @param etd
	 */
	public void update(Etudiant etd) {

		EntityManager em = null;
		EntityTransaction tx = null;

		try {

			em = emf.createEntityManager();

			tx = em.getTransaction();
			tx.begin();
			em.merge(etd);

			tx.commit();

		} catch (Exception ex) {

			// Si il y a des problèmes et une transaction a été déjà crée on l'annule
			if (tx != null) {
				// Annulation d'une transaction
				tx.rollback();

			}

			throw ex;

		} finally {

			// Si la em n'est pas encore fermée par commit
			if (em != null && em.isOpen()) {
				em.close();
			}

		}

	}

	/**
	 * Méthode pour la suppression d'un étudiant
	 * 
	 * @param pId : identifiant de l'entité à supprimer
	 */

	public void delete(Long pId) {

		EntityManager em = null;
		EntityTransaction tx = null;

		try {

			em = emf.createEntityManager();

			tx = em.getTransaction();
			tx.begin();
			em.remove(em.find(Etudiant.class, pId));

			tx.commit();

		} catch (Exception ex) {

			// Si il y a des problèmes et une transaction a été déjà crée on l'annule
			if (tx != null) {
				// Annulation d'une transaction
				tx.rollback();

			}

			throw ex;

		} finally {

			// Si la em n'est pas encore fermée par commit
			if (em != null && em.isOpen()) {
				em.close();
			}

		}

	}

	/**
	 * Méthode permettant de chercher une entité étudiant par son nom
	 * 
	 * @param pName
	 * @return
	 */
	public List<Etudiant> finByName(String pName) {
		EntityManager em = null;
		List<Etudiant> list = null;

		try {

			em = emf.createEntityManager();

			Query query = em.createQuery("select e  from com.bo.Etudiant e where nom=?0");

			query.setParameter(0, pName);

			list = query.getResultList();

		} finally {

			// Si la em n'est pas encore fermée par commit
			if (em != null && em.isOpen()) {
				em.close();
			}

		}

		return list;

	}

	/**
	 * Permet de récupérer toutes les entités enregistrées en base de données
	 * 
	 * @return
	 */
	public List<Etudiant> findAll() {
		EntityManager em = null;
		List<Etudiant> list = null;

		try {

			em = emf.createEntityManager();

			Query query = em.createQuery("select e from com.bo.Etudiant e");

			list = query.getResultList();

		} finally {

			// Si la em n'est pas encore fermée par commit
			if (em != null && em.isOpen()) {
				em.close();
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
	public Etudiant findById(Long pId) {

		Etudiant etd = null;

		EntityManager em = null;

		try {

			em = emf.createEntityManager();

			etd = (Etudiant) em.find(Etudiant.class, pId);

		} catch (Exception ex) {

			throw ex;

		} finally {

			// Si la em n'est pas encore fermée par commit
			if (em != null && em.isOpen()) {
				em.close();
			}

		}

		return etd;

	}

}
