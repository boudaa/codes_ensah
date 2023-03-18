package com.dao;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import com.bo.Adresse;
import com.bo.Etudiant;

/**
 * Permet de récupérer la fabrique des sessions pour Hibernate version >= 4
 * 
 * est donc necessaire
 * 
 * @author T.BOUDAA
 *
 */
public class SessionFactoryBuilder {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {

			Map<String, String> settings = new HashMap<>();
			settings.put("connection.driver_class", "org.mariadb.jdbc.Driver");
			settings.put("dialect", "org.hibernate.dialect.MariaDB103Dialect");
			settings.put("hibernate.connection.url", "jdbc:mysql://localhost/Exemple_Cours_Hibernate_2_many_to_many");
			settings.put("hibernate.connection.username", "root");
			settings.put("hibernate.hbm2ddl.auto", "create");
			settings.put("hibernate.connection.password", "");
			settings.put("hibernate.current_session_context_class", "thread");
			settings.put("hibernate.show_sql", "false");
			settings.put("hibernate.format_sql", "true");

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(settings).build();

			MetadataSources metadataSources = new MetadataSources(serviceRegistry);
			metadataSources.addAnnotatedClass(Etudiant.class);
			metadataSources.addAnnotatedClass(Adresse.class);
			Metadata metadata = metadataSources.buildMetadata();

			sessionFactory = metadata.getSessionFactoryBuilder().build();

		}

		return sessionFactory;
	}

}
