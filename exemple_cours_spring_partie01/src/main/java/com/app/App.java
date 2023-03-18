package com.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ensah.UserService;
import com.ensah.UserServiceImpl;

public class App {

	public static void main(String[] args) {

		System.out.println("========== Initialisation du context de Spring =============");
		System.out.println("Création des bean et injections des dépendances ....");
		// On récupère le context (Standalone XML application context)
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("===================================");

		System.out.println(" ======Test 1====== ");

		// On peut récupérer le bean par son identifiant
		// Cette méthode retourne Object donc ça nécessite un transtypage (càd le Cast
		// de Objet en (UserService))
		UserService bean1 = (UserService) context.getBean("userServiceImpl");
		bean1.testService();

		System.out.println(" ======Test 2====== ");

		// On peut récupérer le bean par son identifiant et son type
		// Cette méthode ne nécessite pas un transtypage
		UserService bean2 = context.getBean("userServiceImpl", UserServiceImpl.class);
		bean2.testService();

		System.out.println(" ======Test 3====== ");

		// Il y a une autre méthode qui permet de récupérer le bean par son type
		// (Return the bean instance that uniquely matches the given object type, if
		// any)
		UserService bean3 = context.getBean(UserServiceImpl.class);
		bean3.testService();
		System.out.println(" ======Test 4====== ");
		if (bean1 == bean2 && bean2 == bean3) {
			System.out.println("userServiceImpl est une singleton");
		} else {
			System.out.println("userServiceImpl n'est pas une singleton");

		}
		System.out.println(" ================= ");
		// Fermeture du context
		// Comme ça on pourra voir l'effet de l'annotation @PreDestroy)
		context.close(); // (Close this application context, destroying all beans in its bean factory)

	}
}
