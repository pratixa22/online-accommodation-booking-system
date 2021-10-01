package com.sunbeam.services;

import java.util.List;
import com.sunbeam.entities.Payment;

public interface PaymentService {	
		List<Payment> findAll();
		Payment findById(int id);
		//List<Payment> findAllByCustomer(Payment payment);
		Payment save(Payment a);	
}
