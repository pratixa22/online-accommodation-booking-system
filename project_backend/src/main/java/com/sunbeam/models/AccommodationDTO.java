package com.sunbeam.models;



import java.util.Date;

import org.springframework.beans.BeanUtils;


import com.sunbeam.entities.Accommodations;


public class AccommodationDTO {
	
	private int id;
	private String title;
	private String location;
	private String type;
	private String description;
	private int guest;	
	private float price;
	private String thumbnail;
	private boolean Status; 
//	private static List<ReviewDTO> reviewList = new ArrayList<ReviewDTO>();
	
	
	
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
	
	private Date checkInDate;
	private Date checkOutDate;
	
	
	
	public AccommodationDTO() {
		
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

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
//	public List<ReviewDTO> getReviewList() {
//		return reviewList;
//	}
//	public void setReviewList(List<ReviewDTO> reviewList) {
//		AccommodationDTO.reviewList = reviewList;
//	}
//	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	
	
	

	public static AccommodationDTO fromEntity(Accommodations entity) {
		AccommodationDTO dto = new AccommodationDTO();
		BeanUtils.copyProperties(entity, dto);
		dto.setUserId(entity.getHost().getId());
		dto.setFirstName(entity.getHost().getFirstName());
		dto.setLastName(entity.getHost().getLastName());
		dto.setEmail(entity.getHost().getEmail());
		dto.setPhoneNo(entity.getHost().getPhoneNo());
		
		dto.setAddressLine1(entity.getAddress().getAddressLine1());
		dto.setAddressLine2(entity.getAddress().getAddressLine2());
		dto.setCity(entity.getAddress().getCity());
		dto.setState(entity.getAddress().getState());
		dto.setPincode(entity.getAddress().getPincode());
		
		
		
//		List<Review> list = entity.getReviewList();		
//		for(Review review : list ) {
//			reviewList.add(ReviewDTO.fromEntity(review));
//		}
//		dto.setReviewList(reviewList);
		return dto;
	}

	public boolean getStatus() {
		return Status;
	}

	public void setStatus(boolean status) {
		Status = status;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

}
