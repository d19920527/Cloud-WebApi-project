package com.wei.webapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name="users")
public class users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String user_uuid;
		private String name;
		private String email;
		private String username;
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
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
}
