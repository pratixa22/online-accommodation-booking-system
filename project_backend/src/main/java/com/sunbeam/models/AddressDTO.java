package com.sunbeam.models;

import org.springframework.beans.BeanUtils;
import com.sunbeam.entities.Address;

public class AddressDTO {

	private int id;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private int pincode;	
	private int accoId;
	
	public AddressDTO() {
		
	}

	public AddressDTO(int id, String addressLine1, String addressLine2, String city, String state, int pincode,
			int accoId) {
		super();
		this.id = id;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.accoId = accoId;
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



	public int getAccoId() {
		return accoId;
	}

	public void setAccoId(int accoId) {
		this.accoId = accoId;
	}

	@Override
	public String toString() {
		return "AddressDTO [id=" + id + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city="
				+ city + ", state=" + state + ", pincode=" + pincode + ", accoId=" + accoId + "]";
	}

	public static AddressDTO fromEntity(Address entity) {
		AddressDTO dto = new AddressDTO();
		BeanUtils.copyProperties(entity, dto);
		dto.setAccoId(entity.getAcco().getId());
		return dto;
	}

	public static Address toEntity(AddressDTO dto) {
		Address entity = new Address();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	
}
