package com.sunbeam.daos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sunbeam.entities.Accommodations;
import com.sunbeam.entities.Order;
import com.sunbeam.entities.User;

public interface OrderDao extends JpaRepository<Order, Integer> {
	List<Order> findAll();
	Order findById(int id);
	List<Order> findAllByCustomer(User customer);
	List<Order> findAllByAcco(Accommodations acco);

	void deleteById(int id);
	
	@Query(nativeQuery = true, value=  "select * from orders where acco_id = :id ORDER BY created_timestamp DESC LIMIT 1")
	Order getOrder(@Param("id") int id);
}
