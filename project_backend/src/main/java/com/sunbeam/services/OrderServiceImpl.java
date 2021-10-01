package com.sunbeam.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.daos.OrderDao;
import com.sunbeam.entities.Accommodations;
import com.sunbeam.entities.Order;
import com.sunbeam.entities.User;

@Transactional
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDao od;	
	
	@Override
	public Order save(Order a) {		
		return od.save(a);
	}

	@Override
	public Order findById(int id) {
		return od.findById(id);
	}

	@Override
	public List<Order> findAllByCustomer(User customer) {
		return od.findAllByCustomer(customer);
	}

	@Override
	public List<Order> findAll() {
		return od.findAll();
	}

	@Override
	public List<Order> findAllByAcco(Accommodations acco) {
		return od.findAllByAcco(acco);
	}

	@Override
	public void deleteById(int id) {
		od.deleteById(id);
		
	}

	@Override
	public Order getOrderService(int id) {
		
		return od.getOrder(id);
	}
}
