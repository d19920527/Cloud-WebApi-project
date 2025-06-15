package com.wei.webapi.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wei.webapi.model.users;

public interface UsersRepository extends JpaRepository<users,Long> {
	
}
