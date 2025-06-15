package com.wei.webapi.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wei.webapi.model.tickets;
import com.wei.webapi.model.users;

public interface TicketsRepository  extends JpaRepository<tickets,Long>{
	
}
