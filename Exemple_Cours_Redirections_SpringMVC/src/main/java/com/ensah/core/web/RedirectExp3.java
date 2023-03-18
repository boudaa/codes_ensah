package com.ensah.core.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/RedirectExp3")
@Controller
public class RedirectExp3 {

	@GetMapping("/source1")
	public ModelAndView source1(ModelMap model, RedirectAttributes attributes) {

		model.addAttribute("model_att", "model_att");
		attributes.addFlashAttribute("flash_att", "flash_att");

		System.out.println("############# Source 1 executed");

		return new ModelAndView("redirect:/RedirectExp3/destination1", model);
	}

	@RequestMapping("/destination1")
	public String destination1(ModelMap model, RedirectAttributes attributes) {

		System.out.println("model_att=" + model.getAttribute("model_att"));
		System.out.println("flash_att=" + model.getAttribute("flash_att"));

		System.out.println("############# Destination 1 executed");
		return "test";

	}
}
