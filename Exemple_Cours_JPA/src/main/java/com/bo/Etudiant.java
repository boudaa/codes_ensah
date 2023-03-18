package com.bo;


import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "ETUDIANT_TAB")
public class Etudiant {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	private String nom;
	private String cin;	
	


	private String prenom;

	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", cin=" + cin + ", prenom=" + prenom + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	



}
