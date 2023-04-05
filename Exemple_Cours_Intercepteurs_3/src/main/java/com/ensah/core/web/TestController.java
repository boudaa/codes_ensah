package com.ensah.core.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	private Logger LOGGER = Logger.getLogger(getClass().getName());

	@RequestMapping("/test")
	public String test() {

		LOGGER.debug("Execution de la méthode test du controleur");
		return "test";
	}
	
	@RequestMapping("/admin")
	public String admin() {

		LOGGER.debug("Execution de la méthode admin du controleur");
		return "test";
	}
	@RequestMapping("/admin/old")
	public String old() {

		LOGGER.debug("Execution de la méthode old du controleur");
		return "test";
	}
	
	@RequestMapping("/admin/test")
	public String adminTest() {

		LOGGER.debug("Execution de /admin/test ");
		return "test";
	}
}
