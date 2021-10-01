package com.sunbeam.models;

import org.springframework.beans.BeanUtils;
import com.sunbeam.entities.Accommodations;

public class AccommodationDTOAll {
		
	private int id;
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
	private boolean status;
	public AccommodationDTOAll() {
		
	}
	public AccommodationDTOAll(int id, String title, String location, String thumbnail, int userId, String firstName) {
		super();
		this.id = id;
		this.title = title;
		this.location = location;
		this.thumbnail = thumbnail;
		this.userId = userId;
		this.firstName = firstName;
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
	
	@Override
	public String toString() {
		return "AccommodationDTO [id=" + id + ",  title=" + title + ", location=" + location
				+ ", thumbnail=" + thumbnail + "]";
	}	
	
	public static AccommodationDTOAll fromEntity(Accommodations entity) {
		AccommodationDTOAll dto = new AccommodationDTOAll();
		BeanUtils.copyProperties(entity, dto);
		dto.setUserId(entity.getHost().getId());
		//System.out.println(dto.getId());
		dto.setFirstName(entity.getHost().getFirstName());
		dto.setLastName(entity.getHost().getLastName());
		//System.out.println(dto.getFirstName());
		return dto;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

}
