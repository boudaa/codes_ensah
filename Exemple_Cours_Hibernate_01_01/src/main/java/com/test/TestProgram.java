package com.test;

import java.util.List;
import java.util.Random;

import com.bo.Etudiant;
import com.dao.HibernateEtudiantDaoImpl;

public class TestProgram {
	public static void main(String[] args) {

		HibernateEtudiantDaoImpl dao = new HibernateEtudiantDaoImpl();
		List<Etudiant> list = null;
		try {

			// Création de deux objets Etudiant tansitoires
			Etudiant etd1 = new Etudiant();
			etd1.setNom("boudaa" + new Random().nextInt(1, 9999999));
			etd1.setPrenom("Mohamed" + new Random().nextInt(1, 9999999));
			etd1.setCin("A11111" + new Random().nextInt(1, 9999999));
			etd1.setValeurCalculée(100);

			Etudiant etd2 = new Etudiant();
			etd2.setNom("boudaa" + new Random().nextInt(1, 9999999));
			etd2.setPrenom("Tarik" + new Random().nextInt(1, 9999999));
			etd2.setCin("B11111" + new Random().nextInt(1, 9999999));
			etd2.setValeurCalculée(200);

			// enregister dans la base de données les deux objets (les rendre persistants)
			dao.save(etd1);
			dao.save(etd2);

			System.out.println("Etudiant sauvegardé, son id est " + etd1.getId());
			System.out.println("Etudiant sauvegardé, son id est " + etd2.getId());

			// Afficher à nouveau tous les enregistrement en base
			System.out.println("-------------Les étudiants enregistrés en base de données : -----------");

			list = dao.findAll();
			for (Etudiant it : list) {
				System.out.println(it);
			}

			// Récupérer un étudiant par son identifiant de la base de données
			Etudiant etd3 = dao.findById(Long.valueOf(etd1.getId()));
			System.out.println("Etudiant bien récupé de la base de données " + etd3);

			// Supprimer un étudiant
			dao.delete(etd3.getId());

			// afficher à nouveau tous les enregistrement en base
			System.out.println(
					"-------------Les étudiants enregistrés en base de données après suppression : -------------");
			list = dao.findAll();
			for (Etudiant it : list) {
				System.out.println(it);
			}

			// Méttre à jour le nom d'un étudiant
			etd2.setNom("Alami" + new Random().nextInt(1, 9999999));
			// attacher à la session pour que les mises à jours prennent effet
			dao.update(etd2);

			// On affiche la liste des étudiants en base de données aynt le nom boudaa
			list = dao.finByName("boudaa" + new Random().nextInt(1, 9999999));

			System.out.println("-------------La liste des étudiants  ayant le nom boudaa-------------");
			for (Etudiant it : list) {
				System.out.println(it);
			}

			// afficher à nouveau tous les enregistrement en base
			System.out.println("-------------Les étudiants enregistrés en base de données : -----------");

			list = dao.findAll();
			for (Etudiant it : list) {
				System.out.println(it);
			}

			System.out.println("Les étudiants ayant le nom & prénom tarik boudaa ");

			list = dao.findByCriteria("com.bo.Etudiant", new String[] { "nom", "prenom" },
					new String[] { "boudaa", "Tarik" });

			System.out.println(
					"------------- Les étudiants enregistrés en base de données avec le nom boudaa et prénom tarik: -----------");
			for (Etudiant it : list) {
				System.out.println(it);
			}

			System.out.println("Terminé avec succès");
		} catch (Exception ex) {

			// on affiche un message d'erreur

			ex.printStackTrace();

		}
	}
}
