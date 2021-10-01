package com.sunbeam.models;

public class UserRedux {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String role;
	private String approvalStatus;
	
	public UserRedux() {
	}
	public UserRedux(int id, String firstName, String lastName, String email, String role, String approvalStatus) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.approvalStatus = approvalStatus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	@Override
	public String toString() {
		return "UserRedux [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", role=" + role + ", approvalStatus=" + approvalStatus + "]";
	}
	
	
}