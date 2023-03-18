package com.ensah;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class Student {
	

	private Long id;
	private String firstName;
	private String lastName;
	private String contactNumber;
	private String cne;	
    @DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date birthDate;
	private String email;

	public Student() {
	}

	public Student(String firstName, String lastName, String contactNumber, String cne, Date birthDate, String email) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.cne = cne;
		this.birthDate = birthDate;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", contactNumber="
				+ contactNumber + ", cne=" + cne + ", birthDate=" + birthDate + ", email=" + email + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

}
