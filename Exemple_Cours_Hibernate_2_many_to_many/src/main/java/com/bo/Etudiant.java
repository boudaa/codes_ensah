package com.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity(name = "ETUDIANT_TAB")
public class Etudiant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	private String nom;
	private String cin;
	private String prenom;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "adresse_etudiant", joinColumns = @JoinColumn(name = "id_etudiant"), inverseJoinColumns = @JoinColumn(name = "id_adresse"))
	private Set<Adresse> adresses = new HashSet<Adresse>();

	public void setAdresses(Set<Adresse> adresses) {
		this.adresses = adresses;
		for (Adresse add : adresses) {
			add.getEtudiants().add(this);
		}
	}

	public void addAdresse(Adresse add) {
		adresses.add(add);
		add.getEtudiants().add(this);
	}

	public void removeAdresse(Adresse add) {
		adresses.remove(add);
		add.getEtudiants().remove(this);
	}

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

	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", cin=" + cin + ", adresse=" + adresses + ", prenom=" + prenom
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

	public Set<Adresse> getAdresses() {
		return adresses;
	}

}
