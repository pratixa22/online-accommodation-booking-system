package com.sunbeam.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sunbeam.entities.Order;
import com.sunbeam.entities.Payment;
import com.sunbeam.models.PaymentDTO;
import com.sunbeam.services.AccommodationService;
import com.sunbeam.services.CustomerService;
import com.sunbeam.services.OrderService;
import com.sunbeam.services.PaymentService;

@RequestMapping("/payment")
@CrossOrigin
@RestController
public class PaymentController {
		
	@Autowired
	CustomerService cs;
	@Autowired
	AccommodationService as;	
	@Autowired
	OrderService os;
	@Autowired
	PaymentService ps;
	
	//Book / order an accommodation
	@PostMapping("/new")
	public ResponseEntity<String> save(@RequestBody PaymentDTO dto){
		
		Order order = os.findById(dto.getOrder_id());
		Payment payment = PaymentDTO.toEntity(dto);
		payment.setOrder(order);
		payment.setCreatedTimestamp(LocalDateTime.now());
		//order.setStatus(true);
		order.setPaymentStatus(true);
		order.setOrderAmount(dto.getPaymentAmount());
		
		ps.save(payment);
		return ResponseEntity.ok("Payment Done");
	}

}
