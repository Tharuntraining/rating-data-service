package com.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.training.dto.UserMovieRatingResponse;
import com.training.service.MovieRatingService;

@RestController
public class MovieRatingController {

	@Autowired
	private MovieRatingService movieRatingService;

	@GetMapping("user-movie-rating/{movieId}")
	public UserMovieRatingResponse getUserMovieRating(@PathVariable("movieId") int movieId) {
		return movieRatingService.getUserMovieRating(movieId);

	}

}
