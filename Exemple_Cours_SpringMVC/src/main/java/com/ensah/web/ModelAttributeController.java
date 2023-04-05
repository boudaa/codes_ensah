package com.ensah.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * L'objectif de cet exemple est de comprendre les différentes utilisation de
 * l'annotation @ModelAttribute
 * 
 * @author Tarik BOUDAA
 *
 */

@Controller
public class ModelAttributeController {

	// Afiche la page index.jsp
	@GetMapping("/")
	public String index() {
		return "index";
	}

	// Cette méthode s'executera avant les méthodes ayant l'annotation de type
	// @RequestMapping (ou ses racourcis)
	// Cette méthode ajoute la clé/valeur ("city", "Al Hoceima") dans le model
	@ModelAttribute
	public void addAttributes(Model model) {
		System.out.println("Méthode addAttributes appelée");
		model.addAttribute("city", "Al Hoceima");
	}

	// Cette méthode s'executera avant les méthodes ayant l'annotation de type
	// @RequestMapping (ou ses racourcis). L'objet de type Person retourné par cette
	// méthode sera ajouté dans le model
	@ModelAttribute("Person")
	public Person populatePerson() {
		System.out.println("populatePerson est executée");
		Person p = new Person();
		p.setFirstName("Tarik");
		p.setLastName("Boudaa");
		return p;
	}

	@GetMapping("test1")
	public String test1(Model model) {

		// On teste que la clé/valeur ("city", "Alhoceima") est présente dans le modèle
		System.out.println("city= " + model.getAttribute("city"));

		// On teste également que l'objet de type Person a été bien ajouté dans le
		// modème
		System.out.println("Person= " + model.getAttribute("Person"));

		// On peut ajouter d'autres données dans le modèle
		model.addAttribute("text", "welcome to ");

		// On retourne la vue. Dans la vue on accède via les expressions EL aux données
		// stockées dans le modèle
		return "test";
	}

	@GetMapping("test2")
	public String test2(Model model) {
		// Cette méthode fait la même chose que la méthode test1
		System.out.println("city= " + model.getAttribute("city"));
		System.out.println("Person= " + model.getAttribute("Person"));
		model.addAttribute("text", "Bienvenue à ");

		// On retourne la vue. Dans la vue on accède via les expressions EL aux données
		// stockées dans le modèle
		return "test";
	}

}
