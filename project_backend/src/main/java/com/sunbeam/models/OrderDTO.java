package com.sunbeam.models;

import java.time.LocalDateTime;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sunbeam.entities.Order;


public class OrderDTO {

	private int id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date checkInDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date checkOutDate;
	private boolean paymentStatus;
	private boolean HostStatus;
	@JsonProperty("created_timestamp")
	private LocalDateTime createdTimestamp;
	private float orderAmount;
	
	private int accoId;
	private String title;
	private String location;
	private String type;
	private String description;
	private int guest;
	private float price;
	private String thumbnail;
	
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNo;	

	private String hostFirstName;
	private String hostLastName;
	private String hostEmail;
	private String hostPhoneNo;
	
	public OrderDTO() {
	}



	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	

	public LocalDateTime getCreatedTimestamp() {
		return createdTimestamp;
	}



	public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getGuest() {
		return guest;
	}

	public void setGuest(int guest) {
		this.guest = guest;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAccoId() {
		return accoId;
	}

	public void setAccoId(int accoId) {
		this.accoId = accoId;
	}
	
	public String getHostFirstName() {
		return hostFirstName;
	}

	public void setHostFirstName(String hostFirstName) {
		this.hostFirstName = hostFirstName;
	}

	public String getHostLastName() {
		return hostLastName;
	}

	public void setHostLastName(String hostLastName) {
		this.hostLastName = hostLastName;
	}

	public String getHostEmail() {
		return hostEmail;
	}

	public void setHostEmail(String hostEmail) {
		this.hostEmail = hostEmail;
	}

	public String getHostPhoneNo() {
		return hostPhoneNo;
	}

	public void setHostPhoneNo(String hostPhoneNo) {
		this.hostPhoneNo = hostPhoneNo;
	}

	public boolean isPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(float orderAmount) {
		this.orderAmount = orderAmount;
	}
	


	public static OrderDTO fromEntity(Order entity) {
		OrderDTO dto = new OrderDTO();
		BeanUtils.copyProperties(entity, dto);
		dto.setAccoId(entity.getAcco().getId());
		dto.setTitle(entity.getAcco().getTitle());
		dto.setLocation(entity.getAcco().getLocation());
		dto.setType(entity.getAcco().getType());
		dto.setDescription(entity.getAcco().getDescription());
		dto.setGuest(entity.getAcco().getGuest());
		dto.setPrice(entity.getAcco().getPrice());
		dto.setThumbnail(entity.getAcco().getThumbnail());
		
		
		dto.setHostFirstName(entity.getAcco().getHost().getFirstName());
		dto.setHostLastName(entity.getAcco().getHost().getLastName());
		dto.setHostEmail(entity.getAcco().getHost().getEmail());
		dto.setHostPhoneNo(entity.getAcco().getHost().getPhoneNo());
		
		dto.setUserId(entity.getCustomer().getId());
		dto.setFirstName(entity.getCustomer().getFirstName());
		dto.setLastName(entity.getCustomer().getLastName()); 
		dto.setEmail(entity.getCustomer().getEmail()); 
		dto.setPhoneNo(entity.getCustomer().getPhoneNo()); 		
		
		return dto;
	}

	public static Order toEntity(OrderDTO dto) {
		Order entity = new Order();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}



	public boolean isHostStatus() {
		return HostStatus;
	}



	public void setHostStatus(boolean hostStatus) {
		HostStatus = hostStatus;
	}
}
