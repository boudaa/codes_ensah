package com.ensah.core.web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RequestMapping("/RedirectExp2")
@Controller
public class RedirectExp2 {

	@Autowired
	private ServletContext servletContext;

	@RequestMapping("/source1")
	public String source1(RedirectAttributes attributes) {

		attributes.addFlashAttribute("flash_att", "flash_att");

		System.out.println("############# source 1 executed");

		return "redirect:/RedirectExp2/destination1";

	}

	@RequestMapping("/destination1")
	public String destination2(ModelMap model) {

		System.out.println("flash_att=" + model.getAttribute("flash_att"));

		System.out.println("############# Destination 1 executed");

		return "test";
	}

}
