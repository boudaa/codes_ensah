package com.ensah.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ModelAttributeController {
	
	@GetMapping("test1")
	public String test1(ModelMap model) {
		System.out.println("city= " + model.getAttribute("city"));
		System.out.println("Person= " + model.getAttribute("Person"));

		model.addAttribute("text", "welcome to ");
		return "test";
	}

	@GetMapping("test2")
	public String test2(ModelMap model) {
		System.out.println("city= " + model.getAttribute("city"));
		System.out.println("Person= " + model.getAttribute("Person"));
		model.addAttribute("text", "Bienvenue à ");
		return "test";
	}

	@ModelAttribute
	public void addAttributes(Model model) {
		System.out.println("Méthode addAttributes appelée");
		model.addAttribute("city", "Al Hoceima");
	}

	/**
	 * Ceci crée un nouvel objet Personne pour et elle le place dans
	 * le le modèle
	 */
	@ModelAttribute("Person")
	public Person populatePerson() {
		System.out.println("populatePerson est executée");
		Person p = new Person();
		p.setFirstName("Tarik");
		p.setLastName("Boudaa");
		return p;
	}

}
