package com.training.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.model.MovieRating;

@Repository
public interface MovieRatingServiceDao extends JpaRepository<MovieRating, Integer> {

	public List<MovieRating> findByMovie_MovieId(int movieId);

}
