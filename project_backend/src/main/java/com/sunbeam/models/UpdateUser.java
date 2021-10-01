package com.sunbeam.models;

import java.util.Date;

public class UpdateUser {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNo;
	private Date dob;
	private String idProof;
	public UpdateUser() {
	}
	public UpdateUser(String firstName, String lastName, String email, String phoneNo, Date dob, String idProof) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.dob = dob;
		this.idProof = idProof;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getIdProof() {
		return idProof;
	}
	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "UpdateUser [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNo="
				+ phoneNo + ", dob=" + dob + ", idProof=" + idProof + "]";
	}
	

}
