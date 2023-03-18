package com.bo;

import javax.persistence.*;

@Entity(name = "ETUDIANT_TAB")
public class Etudiant {
	@Id // Indique que cet attribut est la clé primaire
	// @GeneratedValue permet de configurer la façon avec laquelle on incrémente la
	// colonne.
	// Par exemple, lorsque vous utilisez Mysql, vous pouvez spécifier
	// auto_increment dans la définition de la table pour la rendre
	// auto-incrémentale
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nom_etudiant", length = 50, nullable = false)
	private String nom;

	@Column(nullable = false, unique = true)
	private String cin;

	// Cette propriété est persistante, elle reçoit une configuration par défaut
	// (Principe de configuration par exception )
	private String prenom;
	// Un objet peut avoir des propriétés que l'on ne souhaite pas
	// rendre persistantes dans la base. Il faut alors impérativement les marquer
	// avec l'annotation  @Transient.
	@Transient
	private int valeurCalculée;

	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", cin=" + cin + ", prenom=" + prenom + ", valeurCalculée="
				+ valeurCalculée + "]";
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

	public int getValeurCalculée() {
		return valeurCalculée;
	}

	public void setValeurCalculée(int valeurCalculée) {
		this.valeurCalculée = valeurCalculée;
	}

}
