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

}
