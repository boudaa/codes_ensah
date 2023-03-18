package com.ensah;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ensah.service.IStudentService;

@Controller
//@RequestMapping("/students")
public class StudentControler {

	// On inject dans service, une instance de type implémentant IStudentService
	@Autowired
	private IStudentService service;

	// Cette méthode sera appelée avec le mapping /test
	@RequestMapping("/test")
	public String showMsg() {

		// Appeler une des méthodes de l'objet référencé par service
		service.create();

		// On returne la vue WEB-INF/view/hello.jsp
		return "hello"; // ==> preffix + hello + .jsp
	}

	// Cette méthode sera appelée par le mapping showForm
	@RequestMapping("/showForm")
	public String showForm(Model model) {

		// Création d'un objet étudiant
		Student s = new Student();
		// initialiser l'objet
		s.setFirstName("Boudaa");
		s.setLastName("Tarik");
		s.setEmail("tarikboudaa@yahoo.fr");

		// On ajoute l'objet étudiant comme attribut du modèle
		model.addAttribute("student_model", s);

		return "form"; // ==> preffix + form + .jsp
	}

	
	//Cette méthode sera appelée par le mapping /addStudent
	//Cette méthode prend en paramètre un objet de type Student
	//cet objet sera initialisé depuis l'attribut du modèle nommé student_model
	@RequestMapping("/addStudent")
	public String process(@ModelAttribute("student_model") Student pStudent) {

		//Afficher l'objet de type student
		System.out.println(pStudent);
		
		return "hello"; // ==> preffix + hello + .jsp
	}
}
