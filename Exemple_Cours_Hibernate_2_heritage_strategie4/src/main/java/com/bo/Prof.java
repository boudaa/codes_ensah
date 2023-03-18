package com.bo;

import javax.persistence.Entity;

@Entity
public class Prof extends Personne {
	private String cin;

	@Override
	public String toString() {
		return "Prof [cin=" + cin + "]";
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

}
