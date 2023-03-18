package com.bo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity(name = "ETUDIANT_TAB")
public class Etudiant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String cin;
	private String prenom;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_etudiant")
	private List<Adresse> adresses = new ArrayList<Adresse>();

	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Etudiant)) {
			return false;
		}
		return id != null && id.equals(((Etudiant) o).getId());
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
	
	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	public void addAdresse(Adresse ad) {
		adresses.add(ad);
	}

	public void removeAdresse(Adresse add) {
		adresses.remove(add);
	}

	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", cin=" + cin + ", adresses=" + adresses + ", prenom=" + prenom
				+ "]";
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
