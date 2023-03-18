package com.ensah.core.dao;

import org.springframework.stereotype.Repository;

import com.ensah.core.bo.Person;
import com.genericdao.HibernateSpringGenericDaoImpl;

@Repository
public class PersonDaoImpl extends HibernateSpringGenericDaoImpl<Person, Long> implements IPersonDao {

	public PersonDaoImpl() {
		super(Person.class);
	}

}
