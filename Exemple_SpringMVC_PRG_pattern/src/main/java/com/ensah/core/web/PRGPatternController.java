package com.ensah.core.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ensah.core.bo.Personne;

//Pattern Post/Redirect/Get.

@Controller
public class PRGPatternController {

	@RequestMapping(value = "/showForm")
	public String showForm(Model model) {
		model.addAttribute("person",new Personne());
		return "form";
	}

	@PostMapping(value = "/addPerson")
	public String addPerson(@ModelAttribute("person") Personne person, final RedirectAttributes redirectAttributes) {

		redirectAttributes.addFlashAttribute("firstName", person.getFirstName());
		redirectAttributes.addFlashAttribute("lastName", person.getLastName());

		return "redirect:/showPerson";

	}

	@RequestMapping(value = "/showPerson")
	public String showPerson(ModelMap model) {

		System.out.println("lastName=" + model.getAttribute("lastName"));
		System.out.println("firstName=" + model.getAttribute("firstName"));
		return "welcome";

	}

}
