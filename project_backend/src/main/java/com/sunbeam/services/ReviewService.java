package com.sunbeam.services;

import java.util.List;
import com.sunbeam.entities.Accommodations;
import com.sunbeam.entities.Review;
import com.sunbeam.entities.User;

public interface ReviewService {	
	    Review save (Review a);
		Review findById(int id);	
		List<Review> findAllByCustomer(User customer);		
		List<Review> findAllByAccommodation(Accommodations acco);
		void deleteByAccommodation(Accommodations acco);
		void deleteByUser(User customer);
}
