package com.ensah;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Nécessaire pour que Spring gere le cycle de vie des objets de cette classe
@Component
public class UserServiceImpl implements UserService {

	// On utilise une injection par attribut
	// Injection d'une instance d'une classe qui implémente RoleDao
	// Ici on suppose qu'il y a une seule classe qui implémente RoleDao
	// Dans le cas contraire il faut ajouter l'annotation @Qualifier
	@Autowired
	private RoleDao roleDao;

	// Injection d'une instance d'une classe qui implémente UserDao
	// Ici on suppose qu'il y a une seule classe qui implémente UserDao
	// Dans le cas contraire il faut ajouter l'annotation @Qualifier
	@Autowired
	private UserDao userDao;

	// Constructeur
	public UserServiceImpl() {

		System.out.println("Instantiation de UserServiceImpl");

	}

	// Code à exécuter après la construction et après l'injection des dépendances
	@PostConstruct
	public void doSomethingAtStarting() {
		System.out.println("Appel de la méthode doSomethingAtStarting de UserServiceImpl");
	}

	// Lorsque l'instance est en train d'être supprimée par le conteneur de Spring
	@PreDestroy
	public void doSomethingAtEnd() {
		System.out.println("Appel de la méthode doSomethingAtEnd de UserServiceImpl");
	}

	// C'est une méthode de test
	public void testService() {
		System.out.println("=== Appel de la méthode test de UserServiceImpl ===");
		System.out.println("Est ce que roleDao est null ? Reponse =" + (roleDao == null));
		System.out.println("Est ce que userDao est null ? Reponse =" + (userDao == null));
	}

}
