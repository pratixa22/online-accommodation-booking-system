package com.sunbeam.daos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sunbeam.entities.Payment;

public interface PaymentDao extends JpaRepository<Payment, Integer> {
	List<Payment> findAll();
	Payment findById(int id);
	//List<Payment> findAllByCustomer(Payment payment);
	
}
