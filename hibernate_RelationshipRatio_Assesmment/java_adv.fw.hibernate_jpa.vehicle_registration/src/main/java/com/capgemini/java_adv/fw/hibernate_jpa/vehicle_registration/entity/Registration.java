package com.capgemini.java_adv.fw.hibernate_jpa.vehicle_registration.entity;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
public class Registration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String registrationNumber;

	private LocalDate expiryDate;

	public int getId() {
		return id;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
}