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
@Table(name = "users_movie_catalog_mapping")
public class UserMovieCatalogMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne(cascade = CascadeType.ALL, targetEntity = MovieCatalogItem.class)
	@JoinColumn(name = "movieid", referencedColumnName = "movieid")
	private MovieCatalogItem movieCatalogItem;

	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Users.class)
	@JoinColumn(name = "userid", referencedColumnName = "userid")
	private Users user;

	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Users.class)
	@JoinColumn(name = "createdby", referencedColumnName = "userid")
	private Users createdBy;

	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Users.class)
	@JoinColumn(name = "updatedby", referencedColumnName = "userid")
	private Users updatedBy;

	@Column(name = "createddate", nullable = false, columnDefinition = "TIMESTAMP DEFAULT NOW()")
	private LocalDateTime createdDate;

	@Column(name = "updateddate", nullable = false, columnDefinition = "TIMESTAMP DEFAULT NOW()")
	private LocalDateTime updatedDate;

	@Column(name = "isactive", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
	private Boolean isActive;

	public UserMovieCatalogMapping() {
		super();
	}

	public UserMovieCatalogMapping(int id, MovieCatalogItem movieCatalogItem, Users user, Users createdBy,
			Users updatedBy, LocalDateTime createdDate, LocalDateTime updatedDate, Boolean isActive) {
		super();
		this.id = id;
		this.movieCatalogItem = movieCatalogItem;
		this.user = user;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.isActive = isActive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MovieCatalogItem getMovieCatalogItem() {
		return movieCatalogItem;
	}

	public void setMovieCatalogItem(MovieCatalogItem movieCatalogItem) {
		this.movieCatalogItem = movieCatalogItem;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Users getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Users createdBy) {
		this.createdBy = createdBy;
	}

	public Users getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Users updatedBy) {
		this.updatedBy = updatedBy;
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

}