package com.sunbeam.daos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sunbeam.entities.Accommodations;
import com.sunbeam.entities.Review;
import com.sunbeam.entities.User;

public interface ReviewDao extends JpaRepository<Review, Integer> {
	Review findById(int id);
	List<Review> findAllByUser(User customer);
	List<Review> findAllByAccommodation(Accommodations acco);
	void deleteByAccommodation(Accommodations acco);
	void deleteByUser(User customer);
}
