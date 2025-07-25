package com.wei.webapi.model;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name = "tickets")
public class tickets {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	private String user_uuid;
	private String movie_uuid;
	private String seat;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime booked_at;
	@Column(name = "statuscode")
	private int statuscode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_uuid() {
		return user_uuid;
	}

	public void setUser_uuid(String user_uuid) {
		this.user_uuid = user_uuid;
	}

	public String getMovie_uuid() {
		return movie_uuid;
	}

	public void setMovie_uuid(String movie_uuid) {
		this.movie_uuid = movie_uuid;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	

	public LocalDateTime getBooked_at() {
		return booked_at;
	}

	public void setBooked_at(LocalDateTime booked_at) {
		this.booked_at = booked_at;
	}

	public int getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}




}
