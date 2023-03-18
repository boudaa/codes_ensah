package com.ensah.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//Exemple de récupération des données envoyées dans l'URI en utilisant @PathVariable
@Controller
public class PathVariableController {
	@GetMapping("/delete/{idPerson}/{idRole}")
	public String delete(@PathVariable("idPerson") int idP, @PathVariable("idRole") int idR) {
		System.out.println("Id Person =" + idP);
		System.out.println("Id Role =" + idR);
		return "test";
	}

//Exemple de récupération des données envoyées dans l'URI en utilisant @PathVariable
// cas des valeurs optionnelles 
	
	@GetMapping(value = { "/deleteRequried", "/deleteRequried/{id}" })
	public String deleteRequried(@PathVariable(name = "id", required = false) String idPerson) {
		if (idPerson != null) {
			System.out.println("ID Person: " + idPerson);
		} else {
			System.out.println("ID Person missing");
		}
		return "test";
	}
}
