package com.wei.webapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wei.webapi.model.tickets;
import com.wei.webapi.service.TicketsRepository;

@RestController
@RequestMapping("/api/tickets")
public class TicketsController {
	private final TicketsRepository TicketsRepository;

	public TicketsController(TicketsRepository ticketsRepository) {
		this.TicketsRepository = ticketsRepository;
	}

	@GetMapping("/ticketsall")
	public List<tickets> getAllTickets() {
		return TicketsRepository.findAll();
	}
}
