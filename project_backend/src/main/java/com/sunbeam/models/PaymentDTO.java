package com.sunbeam.models;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sunbeam.entities.Payment;

public class PaymentDTO {

	private int id;
	private String payMethod;
	
	@JsonProperty("created_timestamp")
	private Date createdTimestamp;
	
	private float paymentAmount;
	private boolean paymentStatus;
	private int order_id;
	
	public PaymentDTO() {
		
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



	public boolean isPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public float getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(float paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}
	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}
	
	
	public static PaymentDTO fromEntity(Payment entity) {
		PaymentDTO dto = new PaymentDTO();
		BeanUtils.copyProperties(entity, dto);
		dto.setOrder_id(entity.getOrder().getId());
		dto.setPaymentStatus(entity.getOrder().getPaymentStatus());
		return dto;
	}

	public static Payment toEntity(PaymentDTO dto) {
		Payment entity = new Payment();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}	
}
