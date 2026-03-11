package com.capgemini.java_adv.fw.hibernate_jpa.vehicle_registration.service;

import java.time.LocalDate;

import com.capgemini.java_adv.fw.hibernate_jpa.vehicle_registration.dao.VehicleDAO;
import com.capgemini.java_adv.fw.hibernate_jpa.vehicle_registration.entity.Registration;
import com.capgemini.java_adv.fw.hibernate_jpa.vehicle_registration.entity.Vehicle;

public class VehicleService {

	VehicleDAO dao = new VehicleDAO();

	// ADD VEHICLE
	public void addVehicle(String brand, String model, String regNumber, LocalDate expiryDate) {

		Vehicle vehicle = new Vehicle();
		vehicle.setBrand(brand);
		vehicle.setModel(model);

		Registration reg = new Registration();
		reg.setRegistrationNumber(regNumber);
		reg.setExpiryDate(expiryDate);

		vehicle.setRegistration(reg);

		dao.addVehicle(vehicle);

		System.out.println("Vehicle added successfully");

		System.out.println("ID: " + vehicle.getId());
		System.out.println("Brand: " + vehicle.getBrand());
		System.out.println("Model: " + vehicle.getModel());
		System.out.println("Registration:");
		System.out.println("  Number: " + reg.getRegistrationNumber());
		System.out.println("  Expiry Date: " + reg.getExpiryDate());
	}

	// SEARCH
	public void searchVehicle(int id) {

		Vehicle v = dao.searchVehicle(id);

		System.out.println("ID: " + v.getId());
		System.out.println("Brand: " + v.getBrand());
		System.out.println("Model: " + v.getModel());
		System.out.println("Registration:");
		System.out.println("  Number: " + v.getRegistration().getRegistrationNumber());
		System.out.println("  Expiry Date: " + v.getRegistration().getExpiryDate());
	}

	// UPDATE
	public void updateRegistration(int vehicleId, LocalDate newDate) {

		dao.updateExpiry(vehicleId, newDate);

		System.out.println("Registration updated successfully");
	}

	// DELETE
	public void deleteVehicle(int id) {

		dao.deleteVehicle(id);

		System.out.println("Vehicle deleted successfully");
	}
}