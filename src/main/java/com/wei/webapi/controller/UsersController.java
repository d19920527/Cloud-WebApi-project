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

import com.wei.webapi.model.users;
import com.wei.webapi.service.UsersRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController

@RequestMapping("/api/users")
@Tag(name = "User API", description = "Operations for managing Users")

public class UsersController {

	private final UsersRepository UsersRepository;

	public UsersController(UsersRepository usersRepository) {
		this.UsersRepository = usersRepository;
	}

	@GetMapping("/usersall")
	@Operation(summary = "檢索所有使用者", description = "查詢所有使用者資料")
	public List<users> getAllUsers() {
		return UsersRepository.findAll();
	}

	@GetMapping("{id}")
	@Operation(summary = "按ID檢索個人資料", description = "查詢個人資料")
	public users getUsersById(@PathVariable Long id) {
		return UsersRepository.findById(id).orElse(null);
	}

	@PostMapping
	@Operation(summary = "創建新的一位使用者", description = "創建新的一位使用者")
	public users createUser(@RequestBody users user) {
		return UsersRepository.save(user);
	}

	@PutMapping("/{id}")
	@Operation(summary = "按ID更新一位使用者資料", description = "按ID更新一位使用者資料")
	public users updateUser(@PathVariable Long id, @RequestBody users updateUser) {
		return UsersRepository.findById(id).map(users -> {
			users.setName(updateUser.getName());
			users.setEmail(updateUser.getEmail());
			return UsersRepository.save(users);
		}).orElse(null);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "按ID刪除一位使用者資料", description = "按ID刪除一位使用者資料")
	public void deleteUser(@PathVariable Long id) {
		UsersRepository.deleteById(id);
	}
}
