package com.capgemini.userprofile.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String username;
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	private Profile profile;

	public User() {
	}

	public User(String username, String email, Profile profile) {
		this.username = username;
		this.email = email;
		this.profile = profile;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}