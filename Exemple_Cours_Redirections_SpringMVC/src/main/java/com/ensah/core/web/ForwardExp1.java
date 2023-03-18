package com.ensah.core.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/ForwardExp1")
@Controller
public class ForwardExp1 {

	@GetMapping("/source1")
	public String source1(HttpServletRequest rq) {
		
		rq.setAttribute("att_rq", "att_rq");
		
		System.out.println("############# Destination Source1 Executed");

        return "forward:/ForwardExp1/destination1";

	}

	@RequestMapping("/destination1")
	public String destination1(HttpServletRequest rq, Model m) {
		

		System.out.println("att_rq=" + rq.getAttribute("att_rq"));
	
		System.out.println("############# Destination 1 executed");

		return "test";

	}
}
