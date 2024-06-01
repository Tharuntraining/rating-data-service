package com.training.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.dao.MovieRatingServiceDao;
import com.training.dto.UserMovieRatingResponse;
import com.training.dto.Users;
import com.training.model.MovieRating;
import com.training.service.MovieRatingService;

@Service
public class MovieRatingServiceImpl implements MovieRatingService {

	@Autowired
	private MovieRatingServiceDao movieRatingServiceDao;

	@Override
	public UserMovieRatingResponse getUserMovieRating(int movieId) {
		List<MovieRating> mappings = movieRatingServiceDao.findByMovie_MovieId(movieId);
		if (mappings.isEmpty()) {
			return null; // Or throw an exception if user not found
		}

		UserMovieRatingResponse response = new UserMovieRatingResponse();
		response.setMovieId(movieId);
		response.setMovieName(mappings.get(0).getMovie().getMovieTitle());

		List<Users> userDetails = mappings.stream().map(mapping -> {
			Users detail = new Users();
			detail.setUserId(mapping.getUser().getUserId());
			detail.setUsername(mapping.getUser().getUsername());
			detail.setRating(mapping.getRating());
			return detail;
		}).collect(Collectors.toList());

		response.setUsers(userDetails);

		return response;
	}

}
