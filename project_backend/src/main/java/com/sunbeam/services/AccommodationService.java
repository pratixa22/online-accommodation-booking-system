package com.sunbeam.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

//import java.util.List;
import com.sunbeam.entities.Accommodations;
import com.sunbeam.entities.User;

public interface AccommodationService {	
		Accommodations save (Accommodations a);
		List<Accommodations> findAll();
		Accommodations findById(int id);	
		List<Accommodations> findAllByHost(User host);		
		Accommodations saveAcco(Accommodations acco , MultipartFile thumbnail);
		List<Accommodations> findAllByLocation (String location);
		void deleteById(int id);
		List<Accommodations> findByStatus(Boolean boolean1);
}
