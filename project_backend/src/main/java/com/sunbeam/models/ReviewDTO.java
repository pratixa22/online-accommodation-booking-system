package com.sunbeam.models;

import java.time.LocalDateTime;
import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sunbeam.entities.Review;

public class ReviewDTO {

	private int id;
	private int rating;
	private String reviewText;
	@JsonProperty("review_date")
	private LocalDateTime reviewDate;

	private int accoId;
	private int userId;

	public ReviewDTO() {

	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public LocalDateTime getReviewDate() {
		return reviewDate;
	}


	public void setReviewDate(LocalDateTime reviewDate) {
		this.reviewDate = reviewDate;
	}
	public int getAccoId() {
		return accoId;
	}

	public void setAccoId(int accoId) {
		this.accoId = accoId;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	@Override
	public String toString() {
		return "ReviewDTO [id=" + id + ", rating=" + rating + ", reviewText=" + reviewText + "]";
	}
	public static ReviewDTO fromEntity(Review entity) {
		ReviewDTO dto = new ReviewDTO();
		BeanUtils.copyProperties(entity, dto);
		dto.setUserId(entity.getUser().getId());
		dto.setAccoId(entity.getAccommodation().getId());
		return dto;
	}
	public static Review toEntity(ReviewDTO dto) {
		Review entity = new Review();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
}
