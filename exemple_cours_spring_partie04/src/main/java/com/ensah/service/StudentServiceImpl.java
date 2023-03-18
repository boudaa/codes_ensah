package com.ensah.service;

import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {

	public void create() {

		System.out.println("Méthode StudentServiceImpl--->create est bien executée");

	}

}
