package com.sunbeam.models;

import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sunbeam.entities.Accommodations;
import com.sunbeam.entities.User;

public class AccommodationInDTO {

	private int id;
	private String title;
	private String location;
	private String type;
	private String description;
	private float price;
	private int guest;
	private MultipartFile thumbnail;
	private User host;
	
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNo;
	
	private int addressId;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private int pincode;
	
	public AccommodationInDTO() {
		
	}

	public AccommodationInDTO(int id, String title, String location, int userId,
			MultipartFile thumbnail) {
		super();
		this.id = id;
		this.title = title;
		this.location = location;
		this.userId = userId;
		this.thumbnail = thumbnail;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public MultipartFile getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(MultipartFile thumbnail) {
		this.thumbnail = thumbnail;
	}
	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getGuest() {
		return guest;
	}
	public void setGuest(int guest) {
		this.guest = guest;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
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
	
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	
	@Override
	public String toString() {
		return "AccommodationInDTO [id=" + id + ", title=" + title + ", location=" + location + ", userId=" + userId
				+ ", thumbnail=" + thumbnail + "]";
	}

	public static Accommodations toEntity(AccommodationInDTO dto) {
		Accommodations entity = new Accommodations();
		BeanUtils.copyProperties(dto, entity, "thumbnail");
		return entity;
	}

}
