package com.sunbeam.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sunbeam.daos.ReviewDao;
import com.sunbeam.entities.Accommodations;
import com.sunbeam.entities.Review;
import com.sunbeam.entities.User;

@Transactional
@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	ReviewDao rd;		

	@Override
	public Review save(Review r) {
		return rd.save(r);
	}

	@Override
	public Review findById(int id) {
		return rd.findById(id);
	}

	@Override
	public List<Review> findAllByCustomer(User customer) {
		return rd.findAllByUser(customer);
	}

	@Override
	public List<Review> findAllByAccommodation(Accommodations acco) {
		return rd.findAllByAccommodation(acco);
	}

	@Override
	public void deleteByUser(User customer) {
		rd.deleteByUser(customer);
	}

	@Override
	public void deleteByAccommodation(Accommodations acco) {
		rd.deleteByAccommodation(acco);
		
	}
}
