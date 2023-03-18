package com.bo;

import javax.persistence.Entity;

import javax.persistence.PrimaryKeyJoinColumn;

@Entity 
@PrimaryKeyJoinColumn(name = "profId") 
public class Prof extends Personne {
	private String cin;

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

}
