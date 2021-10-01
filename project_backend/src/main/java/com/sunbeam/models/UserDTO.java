package com.sunbeam.models;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.sunbeam.entities.User;

public class UserDTO {


	private int id;

	private String firstName;

	private String lastName;
	private String email;
	
	private String phoneNo;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	private String idProof;
	
	private String approvalStatus;

	public UserDTO() {
	}

	public UserDTO(int id, String firstName, String lastName, String email, String phoneNo, Date dob, String idProof,
			String approvalStatus) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.dob = dob;
		this.idProof = idProof;
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

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNo=" + phoneNo + ", dob=" + dob + ", idProof=" + idProof + ", approvalStatus="
				+ approvalStatus + "]";
	}
	
	public static UserDTO fromEntity(User entity) {
		UserDTO dto = new UserDTO();
		BeanUtils.copyProperties(entity, dto);
		
		return dto;
	}

	public static User toEntity(UserDTO dto) {
		User entity = new User();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	


}
