package com.wei.webapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wei.webapi.model.users;
import com.wei.webapi.service.UsersRepository;

@RestController

@RequestMapping("/api/users")

public class UsersController {

	private final UsersRepository UsersRepository;

	public UsersController(UsersRepository usersRepository) {
		this.UsersRepository = usersRepository;
	}

	@GetMapping("/usersall")
	public List<users> getAllUsers() {
		return UsersRepository.findAll();
	}

}
