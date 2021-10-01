package com.sunbeam.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sunbeam.daos.PaymentDao;
import com.sunbeam.entities.Payment;

@Transactional
@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	PaymentDao pd;	
	
	@Override
	public Payment save(Payment a) {		
		return pd.save(a);
	}

	@Override
	public Payment findById(int id) {
		return pd.findById(id);
	}

//	@Override
//	public List<Order> findAllByCustomer(User customer) {
//		return od.findAllByCustomer(customer);
//	}

	@Override
	public List<Payment> findAll() {
		return pd.findAll();
	}
}
