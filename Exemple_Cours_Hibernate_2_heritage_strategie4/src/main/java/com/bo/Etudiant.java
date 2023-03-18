package com.bo;

import javax.persistence.*;



@Entity
public class Etudiant extends Personne {

	private String cne;

	public String getCne() {
		return cne;
	}

	@Override
	public String toString() {
		return "Etudiant [cne=" + cne + "]";
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

}
