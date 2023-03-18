package com.ensah.core.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.core.bo.Person;
import com.ensah.core.dao.IPersonDao;

@Service
@Transactional
public class PersonServiceImpl implements IPersonService {

	@Autowired
	private IPersonDao personDao;

	public void addPerson(Person pPerson) {
		personDao.create(pPerson);
	}

	public List<Person> getAllPersons() {
		return personDao.getAll();
	}

	public void deletePerson(Long id) {
		personDao.delete(id);

	}

	public Person getPersonById(Long id) {
		return personDao.findById(id);

	}

	public void updatePerson(Person pPerson) {
		personDao.update(pPerson);

	}

}
