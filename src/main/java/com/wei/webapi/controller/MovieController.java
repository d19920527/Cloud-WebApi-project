package com.wei.webapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wei.webapi.model.movie;
import com.wei.webapi.service.MovieRepository;

@RestController

@RequestMapping("/api/movie")

public class MovieController {

	private final MovieRepository MovieRepository;

	public MovieController(MovieRepository movieRepository) {

		this.MovieRepository = movieRepository;

	}

	@GetMapping("/movieall")
	public List<movie> getAllmovies() {
		return MovieRepository.findAll();
	}
}
