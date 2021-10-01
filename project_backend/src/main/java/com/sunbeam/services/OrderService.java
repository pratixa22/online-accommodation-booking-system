package com.sunbeam.services;

import java.util.List;


import com.sunbeam.entities.Accommodations;
import com.sunbeam.entities.Order;
import com.sunbeam.entities.User;

public interface OrderService {	
		List<Order> findAll();
		Order findById(int id);
		Order save(Order a);
		List<Order> findAllByCustomer(User customer);
		List<Order> findAllByAcco(Accommodations acco);
		void deleteById(int id);
		
		Order getOrderService( int id);
}
