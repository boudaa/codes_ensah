package com.ensah.core.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensah.core.bo.Person;
import com.ensah.core.services.IPersonService;
import com.genericdao.EntityNotFoundException;

/**
 * Controleur Rest de gestion des personnes
 * 
 * @author T. BOUDAA
 *
 */
@RestController
@RequestMapping("/api")
public class PersonRestController {

	@Autowired
	private IPersonService personService;

	@GetMapping("/persons/{idPerson}")	
	public Person getPersonById(@PathVariable int idPerson) {

		Person p = personService.getPersonById(Long.valueOf(idPerson));
		if (p == null) {
			throw new EntityNotFoundException("The person with id=" + idPerson + " is not found");
		}

		return p;
	}

	@PostMapping("/persons")
	public Person addPerson(@RequestBody Person person) {

		// En cas ou un id a été envoyé on le rend égale à null
		// pour éviter une mise à jour par erreur
		person.setIdPersonne(null);

		personService.addPerson(person);

		return person;
	}

	@PutMapping("/persons")
	public Person updatePerson(@RequestBody Person person) {

	
		personService.updatePerson(person);

		return person;
	}

	@DeleteMapping("/persons/{idPerson}")
	public String deletePersonById(@PathVariable int idPerson) {

		personService.deletePerson(Long.valueOf(idPerson));

		return "deleted person id = " + idPerson;
	}

}
