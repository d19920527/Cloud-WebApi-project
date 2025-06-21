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

import com.wei.webapi.model.tickets;
import com.wei.webapi.service.TicketsRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/tickets")

@Tag(name = "ticket API", description = "Operations for managing tickets")

public class TicketsController {
	private final TicketsRepository TicketsRepository;

	public TicketsController(TicketsRepository ticketsRepository) {
		this.TicketsRepository = ticketsRepository;
	}

	@GetMapping("/ticketsall")
	@Operation(summary = "檢索所有訂票紀錄", description = "查詢所有訂票紀錄")
	public List<tickets> getAllTickets() {
		return TicketsRepository.findAll();
	}

	@GetMapping("/{id}")
	@Operation(summary = "按ID檢索個人訂票紀錄", description = "查詢個人訂票紀錄")
	public tickets getTicketsById(@PathVariable Long id) {
		return TicketsRepository.findById(id).orElse(null);
	}

	@PostMapping
	@Operation(summary = "創建新的一筆訂票", description = "創建新的一筆訂票紀錄")
	public tickets createTickets(@RequestBody tickets tickets) {
		return TicketsRepository.save(tickets);
	}

	@PutMapping("/{id}")
	@Operation(summary = "按ID更新一筆訂票紀錄", description = "按ID更新一筆訂票紀錄")
	public tickets updateTickets(@PathVariable Long id, @PathVariable tickets updateTickets) {
		return TicketsRepository.findById(id).map(tickets -> {
			tickets.setSeat(updateTickets.getSeat());
			tickets.setBooked_at(updateTickets.getBooked_at());
			return TicketsRepository.save(tickets);
		}).orElse(null);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "按ID刪除一筆訂票紀錄", description = "按ID刪除一筆訂票紀錄")
	public void deleteTickets(@PathVariable Long id) {
		TicketsRepository.deleteById(id);
	}
}
