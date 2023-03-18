package com.ensah.core.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/test")
	public String test() {

		System.out.println("Execution de la méthode test du controleur");
		return "test";
	}
	
	@RequestMapping("/admin")
	public String admin() {

		System.out.println("Execution de la méthode admin du controleur");
		return "test";
	}
	@RequestMapping("/admin/old")
	public String old() {

		System.out.println("Execution de la méthode old du controleur");
		return "test";
	}
	
	@RequestMapping("/admin/test")
	public String adminTest() {

		System.out.println("Execution de /admin/test ");
		return "test";
	}
}
