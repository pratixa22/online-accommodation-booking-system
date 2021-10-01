package com.sunbeam.daos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sunbeam.entities.Accommodations;
import com.sunbeam.entities.User;

public interface AccommodationDao extends JpaRepository<Accommodations, Integer> {
	List<Accommodations> findAll();
	Accommodations findById(int id);
	List<Accommodations> findAllByHost(User host);	
	List<Accommodations> findAllByLocation(String location);
	List<Accommodations> findByStatus(Boolean boolean1);
	
}
