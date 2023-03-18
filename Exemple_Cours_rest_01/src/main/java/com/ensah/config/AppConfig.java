package com.ensah.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.ensah.core.bo.Person;


//Configuration d'une application Spring MVC (@EnableWebMvc)
//Avec support des transactions (@EnableTransactionManagement)

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.ensah" })
@EnableTransactionManagement
public class AppConfig implements WebMvcConfigurer {

	/** Utilisé pour la journalisation */
	private Logger LOGGER = Logger.getLogger(getClass().getName());

	public AppConfig() {

		LOGGER.info(" configuration init...");
	}

	// Configuration du ViewResolver

	@Bean
	public ViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/view/");
		bean.setSuffix(".jsp");
		return bean;
	}

	// Configuration de la Template HibernateTemplate

	@Bean
	@Autowired
	public HibernateTemplate hibernateTemplate(final SessionFactory sessionFactory) {
		HibernateTemplate hibernateTemplate = new HibernateTemplate();
		hibernateTemplate.setSessionFactory(sessionFactory);

		if (hibernateTemplate != null) {
			LOGGER.debug(" HibernateTemplate created ...");
		}

		return hibernateTemplate;
	}

	// Configuration de la Session Factory de Hibernate
	@Bean
	public LocalSessionFactoryBean sessionFactory() {

		final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setHibernateProperties(hibernateProperties());

		sessionFactory.setAnnotatedClasses(Person.class);

		// méthode à tester setAnnotatedPackages("com.bo");

		if (sessionFactory != null) {
			LOGGER.debug(" sessionFactory created ...");
		}

		System.out.println("LocalSessionFactoryBean..." + sessionFactory);
		return sessionFactory;
	}

	// Les propriétés de la configuration Hibernate
	public Properties hibernateProperties() {

		Properties hibernateProperties = new Properties();

		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MariaDB103Dialect");
		hibernateProperties.setProperty("hibernate.show_sql", "true");

		// ....

		return hibernateProperties;
	}

	// Configuration de la source de données
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/dbTestCours");

		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}

	// Permet de traduire toutes les exceptions de la couche persistance en une
	// seule exception
	// de type PersistenceExceptionTranslationPostProcessor (embalage des execptions
	// de la couche de persistance)
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	// Configuration du Gestionnaire des Transactions
	// Spring définit une API pour la gestion des Transactions
	// (PlatformTransactionManager) qui cache l'implémentation réelle du
	// gestionnaire
	// de transactions pour ne pas dépendre l'application (couche service) avec
	// les implémentations (avec les frameworks sous-jacents utilisés dans la couche
	// dao)
	// Ici nous avons configué un gestionnaire de transactions pour Hibernate
	// (HibernateTransactionManager) mais que nous retournons sous forme de
	// PlatformTransactionManager
	// (car HibernateTransactionManager est une implémentation de
	// HibernateTransactionManager)t

	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(final SessionFactory sessionFactory) {

		final HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		if (txManager != null) {
			LOGGER.debug(" Hibernate Transaction Manager created ...");

		}

		return txManager;

	}



}