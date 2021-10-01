package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
//, uniqueConstraints = @UniqueConstraint(name= "email_phoneNo" , columnNames = {"email","phoneNo"})
@Entity
@Table(name = "customers")
public class User {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private String email;
	@Column(name = "phone_no")
	private String phoneNo;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dob;
	private String password;
	@Column(name = "id_proof")
	private String idProof;
	private String role = "user";
	@Column(name = "approval_status")
	private String approvalStatus;
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "host",cascade = CascadeType.ALL,orphanRemoval=true)
	private List<Accommodations> accomList = new ArrayList<>();
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL,orphanRemoval=true)
	private List<Order> orderList = new ArrayList<>();
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval=true)
	private List<Review> reviewsList = new ArrayList<>();

	public User() {
	}

	public User(int id, String firstName, String lastName, String email, String phoneNo, Date dob, String password,
			String idProof, String role, String approvalStatus, List<Accommodations> accomList, List<Order> orderList,
			List<Review> reviewsList) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.dob = dob;
		this.password = password;
		this.idProof = idProof;
		this.role = role;
		this.approvalStatus = approvalStatus;
		this.accomList = new ArrayList<Accommodations>();
		this.orderList = new ArrayList<>();
		this.reviewsList = new ArrayList<>();
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Accommodations> getAccomList() {
		return accomList;
	}

	public void setAccomList(List<Accommodations> accomList) {
		this.accomList = accomList;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	
	public List<Review> getReviewsList() {
		return reviewsList;
	}

	public void setReviewsList(List<Review> reviewsList) {
		this.reviewsList = reviewsList;
	}



}
