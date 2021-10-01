package com.sunbeam.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Reviews")
public class Review {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private int rating;
	private String reviewText;

	@Column(name = "review_date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDateTime reviewDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "acco_id")
	Accommodations accommodation;

	public Review() {

	}

	public Review(int id, int rating, LocalDateTime reviewDate, String reviewText, Accommodations accommodation) {
		super();
		this.id = id;
		this.rating = rating;
		// this.reviewDate = reviewDate;
		this.reviewText = reviewText;
		this.accommodation = accommodation;
	}

	public int getId() {
		return id;
	}

	public void setId(int reviewId) {
		this.id = reviewId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

//	public LocalDateTime getReviewDate() {
//		return reviewDate;
//	}
//
//	public void setReviewDate(LocalDateTime reviewDate) {
//		this.reviewDate = reviewDate;
//	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Accommodations getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(Accommodations accommodation) {
		this.accommodation = accommodation;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public LocalDateTime getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(LocalDateTime reviewDate) {
		this.reviewDate = reviewDate;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating + ", reviewText=" + reviewText + ", user=" + user
				+ ", accommodation=" + accommodation + "]";
	}

}
