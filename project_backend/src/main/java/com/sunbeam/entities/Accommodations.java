package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "AccommodationList")
public class Accommodations {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private boolean status;
	private String title;
	private String location;
	private String type;
	private String description;
	private int guest;
	private float price;
	private String thumbnail;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	User host;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "acco", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Order> bookingList = new ArrayList<>();

	@JsonIgnore
	@JoinColumn(name = "address_id")
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Address address;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accommodation", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Review> reviewList = new ArrayList<>();

	public Accommodations() {
	}

	public Accommodations(int id, String title, String location, String type, int guest, String thumbnail, User host,
			List<Order> bookingList) {
		this.id = id;
		this.title = title;
		this.location = location;
		this.type = type;
		this.guest = guest;
		this.thumbnail = thumbnail;
		this.host = host;
		this.bookingList = new ArrayList<>();
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

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
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


	public List<Order> getBookingList() {
		return bookingList;
	}

	public void setBookingList(List<Order> bookingList) {
		this.bookingList = bookingList;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List<Review> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}


	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
