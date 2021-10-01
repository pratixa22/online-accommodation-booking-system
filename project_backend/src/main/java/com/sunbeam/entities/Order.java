package com.sunbeam.entities;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Orders")
public class Order {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date checkInDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date checkOutDate;
	
	private boolean paymentStatus;
	
	private boolean hostStatus;
	
	private float orderAmount;
	
	@Column(name = "created_timestamp")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDateTime createdTimestamp;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id") // FK column in customer table.
	User customer;
	
//	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "acco_id") // FK column in customer table.
	Accommodations acco;
	
	@JsonIgnore
	@OneToOne(mappedBy="order", fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval=true)
	private Payment payment;

	public Order() {
	
	}

	public Order(int id, Date checkInDate, Date checkOutDate, User customer, Accommodations acco,LocalDateTime createdTimestamp, boolean paymentStatus) {
		super();
		this.id = id;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.customer = customer;
		this.acco = acco;
		this.createdTimestamp = createdTimestamp;
		this.paymentStatus = paymentStatus;
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
	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}
	
	public Accommodations getAcco() {
		return acco;
	}

	public void setAcco(Accommodations acco) {
		this.acco = acco;
	}
	

	public boolean getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public float getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(float orderAmount) {
		this.orderAmount = orderAmount;
	}

	public boolean isHostStatus() {
		return hostStatus;
	}

	public void setHostStatus(boolean hostStatus) {
		hostStatus = hostStatus;
	}
	
}
