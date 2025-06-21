package com.wei.webapi.model;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name="movie")

public class movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String movid_uuid;
		private String title;
		private String duration;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getMovid_uuid() {
			return movid_uuid;
		}
		public void setMovid_uuid(String movid_uuid) {
			this.movid_uuid = movid_uuid;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDuration() {
			return duration;
		}
		public void setDuration(String duration) {
			this.duration = duration;
		}
		
}


