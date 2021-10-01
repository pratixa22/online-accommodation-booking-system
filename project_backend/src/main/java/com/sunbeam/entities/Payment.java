package com.sunbeam.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Payments")
public class Payment {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String payMethod;
	
	@Column(name = "created_timestamp")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDateTime createdTimestamp;
	
	private float paymentAmount;
	
	@JoinColumn(name="order_id")
	@OneToOne( fetch = FetchType.LAZY)
	private Order order;

	public Payment() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}



	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	public LocalDateTime getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public float getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(float paymentAmount) {
		this.paymentAmount = paymentAmount;
	}		
}
