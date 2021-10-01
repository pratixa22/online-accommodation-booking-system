package com.sunbeam.controllers;


import java.time.LocalDateTime;
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
import com.sunbeam.entities.Review;
import com.sunbeam.entities.User;
import com.sunbeam.models.Response;
import com.sunbeam.models.ReviewDTO;
import com.sunbeam.services.AccommodationService;
import com.sunbeam.services.CustomerService;
import com.sunbeam.services.ReviewService;

@RequestMapping("/review")
@CrossOrigin
@RestController
public class ReviewController {
		
	@Autowired
	CustomerService cs;
	@Autowired
	AccommodationService as;	
	@Autowired
	ReviewService rs;
	
	//post new review
	@PostMapping("/new")
	public ResponseEntity<String> save(@RequestBody ReviewDTO dto){
		Accommodations acco = as.findById(dto.getAccoId());
		User customer = cs.findById(dto.getUserId());
		Review review = ReviewDTO.toEntity(dto);
		review.setUser(customer);
		review.setAccommodation(acco);
		review.setReviewDate(LocalDateTime.now());
		rs.save(review);
		return ResponseEntity.ok("Review added");
	}
	
	//find all the reviews of a user with the help of user_id
	@GetMapping("/userId/{userId}")
	public ResponseEntity<?> findReviewsByUserID(@PathVariable("userId") int userId){
		User customer = cs.findById(userId);
		List<Review> list = rs.findAllByCustomer(customer);
		Stream<ReviewDTO> result = list.stream().map(Review -> ReviewDTO.fromEntity(Review));
		return Response.success(result);
	}
	
	//find all the reviews of a accommodation with the help of acco_id
		@GetMapping("/accoId/{accoId}")
		public ResponseEntity<?> findReviewsByAccoID(@PathVariable("accoId") int accoId){
			Accommodations acco = as.findById(accoId);
			List<Review> list = rs.findAllByAccommodation(acco);
			Stream<ReviewDTO> result = list.stream().map(Review -> ReviewDTO.fromEntity(Review));
			return Response.success(result);
		}	

		@DeleteMapping("/deleteAccoId/{accoId}")
		public ResponseEntity<String> deleteAllReviewByAccommodation(@PathVariable("accoId") int accoId){
			Accommodations acco = as.findById(accoId);
			rs.deleteByAccommodation(acco);
			return ResponseEntity.ok("Reviews deleted");
		}
		
		//if admin wants to delete all the reviews of a particular user
		@DeleteMapping("/deleteUserId/{userId}")
		public ResponseEntity<String> deleteAllReviewByCustomer(@PathVariable("userId") int userId){
			User customer = cs.findById(userId);
			rs.deleteByUser(customer);
			return ResponseEntity.ok("Reviews deleted");
		}

	//Edit review by review id
	@PutMapping("/editReview/{id}")
	public ResponseEntity<String> updateReview(ReviewDTO dto, @PathVariable("id") int id ){
		Review review = rs.findById(id);
		if(dto.getRating() != 0)
			review.setRating(dto.getRating());
		if(dto.getReviewText() != null)
			review.setReviewText(dto.getReviewText());
		review.setReviewDate(LocalDateTime.now());
		rs.save(review);
		return ResponseEntity.ok("Review updated");
	}

}
