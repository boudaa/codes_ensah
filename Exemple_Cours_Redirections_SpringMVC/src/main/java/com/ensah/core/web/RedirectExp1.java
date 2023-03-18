package com.ensah.core.web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RequestMapping("/RedirectExp1")
@Controller
public class RedirectExp1 {

	@Autowired
	private ServletContext servletContext;

	@RequestMapping("/source1")
	public RedirectView sourceMethod1(RedirectAttributes attributes, HttpServletRequest rq) {
		// On stocke un attribut dans la requête
		rq.setAttribute("rq_att", "attribut de requête");
		// Ajout d'un attribut Flash Attribute
		attributes.addFlashAttribute("flash_att", "boudaa");

		System.out.println("############# Source 1 executed");
		// Redirection avec RedirectView
		return new RedirectView(servletContext.getContextPath() + "/RedirectExp1/destination1");

	}

	@RequestMapping("/destination1")
	public String destination1(ModelMap model, HttpServletRequest rq) {

		System.out.println("rq_att=" + rq.getAttribute("rq_att")); // On va avoir null car il s'agit d'une redirection
																	// au niveau client, donc il s'agit d'une nouvelle
																	// requete

		System.out.println("flash_att=" + model.getAttribute("flash_att"));
		
		System.out.println("############# Destination 1 executed");

		return "test";

	}

}
