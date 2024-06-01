package com.training.service;

import com.training.dto.UserMovieRatingResponse;

public interface MovieRatingService {

	public UserMovieRatingResponse getUserMovieRating(int movieId);

}
