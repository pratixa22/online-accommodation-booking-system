package com.sunbeam.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.Accommodations;
import com.sunbeam.entities.Order;
import com.sunbeam.entities.User;
import com.sunbeam.models.OrderDTO;
import com.sunbeam.models.Response;
import com.sunbeam.services.AccommodationService;
import com.sunbeam.services.CustomerService;
import com.sunbeam.services.OrderService;

@RequestMapping("/order")
@CrossOrigin
@RestController
public class OrderController {
		
	@Autowired
	CustomerService cs;
	@Autowired
	AccommodationService as;	
	@Autowired
	OrderService os;
	
	//Book / order an accommodation
		@PostMapping("/new")
		public ResponseEntity<String> save(@RequestBody OrderDTO dto){
			Accommodations acco = as.findById(dto.getAccoId());
			Order order = OrderDTO.toEntity(dto);
			order.setAcco(acco);
			//User customer = cs.findById(acco.getHost().getId());
			User customer = cs.findById(dto.getUserId());
			order.setCustomer(customer);
			order.setCreatedTimestamp(LocalDateTime.now());
			os.save(order);
			return ResponseEntity.ok("Order added");
		}
	
	//find all the order of a user with the help of user_id
	@GetMapping("/{userId}")
	public ResponseEntity<?> findOrdersByUserId(@PathVariable("userId") int userId){
		User customer = cs.findById(userId);
		List<Order> list = os.findAllByCustomer(customer);
		
		Collections.reverse(list);
		Stream<OrderDTO> result = list.stream().map(Order -> OrderDTO.fromEntity(Order));
		
		return Response.success(result);
	}
	
	//find all the order for host with the help of host_id
	@GetMapping("/host/{hostId}")
	public ResponseEntity<?> findOrdersByHostId(@PathVariable("hostId") int hostId){
				
		User customer = cs.findById(hostId);
		//List<Order> list = new ArrayList<Order>();
		List<Accommodations> accoList = as.findAllByHost(customer);
		List<Order> orderList = new ArrayList<Order>();
		for(Accommodations acco : accoList) {
			List<Order> list = new ArrayList<Order>();
			list = os.findAllByAcco(acco);
			for(Order order : list)
				orderList.add(order);
		}
				
		Stream<OrderDTO> result = orderList.stream().map(Order -> OrderDTO.fromEntity(Order));
		return Response.success(result);
	}
			
	// find order by order Id
	@GetMapping("/orderId/{id}")
	public ResponseEntity<?> findOrderById(@PathVariable("id") int id){
		Order order = os.findById(id);
		OrderDTO result = OrderDTO.fromEntity(order);
		return Response.success(result);
	}
	
	//get list of all the orders for admin portal
	@GetMapping("/orderAll")
	public ResponseEntity<?> findAll(){
		List<Order> list = os.findAll();
		Stream<OrderDTO> result = list.stream().map(Order -> OrderDTO.fromEntity(Order));
		System.out.println(result);
		return Response.success(result);	
	}
	//Edit order by order id
	@PutMapping("/editOrder/{id}")
	public ResponseEntity<String> updateOrder(OrderDTO dto, @PathVariable("id") int id ){
		Order order = os.findById(dto.getId());		
		if(dto.getCheckInDate() != null)
			order.setCheckInDate(dto.getCheckInDate());
		if(dto.getCheckOutDate() != null)
			order.setCheckOutDate(dto.getCheckOutDate());
		order.setCreatedTimestamp(LocalDateTime.now());
		os.save(order);
		return ResponseEntity.ok("Order updated");
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable("id") int id ){	
		os.deleteById(id);
		return ResponseEntity.ok("Order deleted");
	}

	@GetMapping("/acc/{id}")
	public ResponseEntity<?> findOrdersByAcc(@PathVariable("id") int id){
		
		Order list = os.getOrderService(id);
		
		return Response.success(list);
	}
	
	@PutMapping("/bookconfirm/{id}")
	public ResponseEntity<String> confirmBook( @PathVariable("id") int id ){
		Order order = os.findById(id);
		order.setHostStatus(true);
		os.save(order);
		return ResponseEntity.ok("Booking confirm");
	}
}
