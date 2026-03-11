package com.capgemini.userprofile.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String phone;
	private String gender;
	private LocalDate dob;

	public Profile() {
	}

	public Profile(String phone, String gender, LocalDate dob) {
		this.phone = phone;
		this.gender = gender;
		this.dob = dob;
	}

	public int getId() {
		return id;
	}

	public String getPhone() {
		return phone;
	}

	public String getGender() {
		return gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
}