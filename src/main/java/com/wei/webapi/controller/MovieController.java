package com.wei.webapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wei.webapi.model.movie;
import com.wei.webapi.service.MovieRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController

@RequestMapping("/api/movie")

@Tag(name = "Movie API", description = "Operations for managing Movies")

public class MovieController {

	private final MovieRepository MovieRepository;

	public MovieController(MovieRepository movieRepository) {

		this.MovieRepository = movieRepository;

	}

	@GetMapping("/movieall")
	@Operation(summary = "檢索所有電影", description = "查詢所有電影檔次")
	public List<movie> getAllmovies() {
		return MovieRepository.findAll();
	}

	@GetMapping("{id}")
	@Operation(summary = "按ID檢索單個電影", description = "查詢電影代號")
	public movie getMovieById(@PathVariable Long id) {
		return MovieRepository.findById(id).orElse(null);
	}

	@PostMapping
	@Operation(summary = "創建新的一部電影", description = "創建新的一部電影")
	public movie createMovie(@RequestBody movie movie) {
		return MovieRepository.save(movie);
	}

	@PutMapping("{id}")
	@Operation(summary = "按ID更新一部電影內容", description = "按ID更新一部電影內容")
	public movie updateMovie(@PathVariable Long id, @RequestBody movie updateMovie) {
		return MovieRepository.findById(id).map(movie -> {
			movie.setTitle(updateMovie.getTitle());
			movie.setDuration(updateMovie.getDuration());
			return MovieRepository.save(movie);
		}).orElse(null);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "按ID刪除一部電影內容", description = "按ID刪除一部電影內容")
	public void deleteMovie(@PathVariable Long id) {
		MovieRepository.deleteById(id);
	}
}
