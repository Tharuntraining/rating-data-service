package com.training.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "movie_ratings")
public class MovieRating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ratingId;

	@ManyToOne(cascade = CascadeType.ALL, targetEntity = MovieCatalogItem.class)
	@JoinColumn(name = "movieid", referencedColumnName = "movieid")
	private MovieCatalogItem movie;

	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Users.class)
	@JoinColumn(name = "userid", referencedColumnName = "userid")
	private Users user;

	@Column(name = "rating", nullable = false)
	private int rating;

	@Column(name = "createddate", nullable = false, columnDefinition = "TIMESTAMP DEFAULT NOW()")
	private LocalDateTime createdDate;

	@Column(name = "updateddate", nullable = false, columnDefinition = "TIMESTAMP DEFAULT NOW()")
	private LocalDateTime updatedDate;

	@Column(name = "isactive", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
	private Boolean isActive;

	public MovieRating() {
		super();
	}

	public MovieRating(int ratingId, MovieCatalogItem movie, Users user, int rating, LocalDateTime createdDate,
			LocalDateTime updatedDate, Boolean isActive) {
		super();
		this.ratingId = ratingId;
		this.movie = movie;
		this.user = user;
		this.rating = rating;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.isActive = isActive;
	}

	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public MovieCatalogItem getMovie() {
		return movie;
	}

	public void setMovie(MovieCatalogItem movie) {
		this.movie = movie;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
