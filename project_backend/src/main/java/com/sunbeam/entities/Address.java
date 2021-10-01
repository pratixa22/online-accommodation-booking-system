package com.sunbeam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Address")
public class Address {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	@Column(name= "line1")
	private String addressLine1;
	@Column(name= "line2")
	private String addressLine2;
	private String city;
	private String state;
	private int pincode;	
	@JsonIgnore
	@OneToOne(mappedBy="address",fetch = FetchType.LAZY)
	private Accommodations acco;
	
	public Address() {
		
	}

	public Address(int id, String addressLine1, String addressLine2, String city, String state, int pincode,
			Accommodations acco) {
		super();
		this.id = id;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.acco = acco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public Accommodations getAcco() {
		return acco;
	}

	public void setAcco(Accommodations acco) {
		this.acco = acco;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city="
				+ city + ", state=" + state + ", pincode=" + pincode + ", acco=" + acco + "]";
	}
	
}
