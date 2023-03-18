package com.ensah.core.services;

import java.util.List;

import com.ensah.core.bo.Person;

public interface IPersonService {

	public void addPerson(Person pPerson);

	public void updatePerson(Person pPerson);
	
	public List<Person> getAllPersons();
	
	public void deletePerson(Long id);
	
	public Person getPersonById(Long id);

}
