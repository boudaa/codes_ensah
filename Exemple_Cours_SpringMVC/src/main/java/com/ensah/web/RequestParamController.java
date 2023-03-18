package com.ensah.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestParamController {
	@GetMapping(value = "/deletePerson")
	public String delete(@RequestParam(name = "idPerson", defaultValue = "1") int id, @RequestParam("idRole") int idR) {
		System.out.println("Id Person =" + id);
		System.out.println("Id Role =" + idR);
		return "test";
	}

}
