package com.capgemini.java_adv.fw.hibernate_jpa.vehicle_registration.dao;

import java.time.LocalDate;

import com.capgemini.java_adv.fw.hibernate_jpa.vehicle_registration.entity.Vehicle;

import jakarta.persistence.*;

public class VehicleDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("VehicleDB");
	EntityManager em = emf.createEntityManager();

	// ADD
	public void addVehicle(Vehicle vehicle) {

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(vehicle);

		tx.commit();
	}

	// SEARCH using JPQL
	public Vehicle searchVehicle(int id) {

		TypedQuery<Vehicle> query = em.createQuery("SELECT v FROM Vehicle v WHERE v.id = :id", Vehicle.class);

		query.setParameter("id", id);

		return query.getSingleResult();
	}

	// UPDATE expiry
	public void updateExpiry(int vehicleId, LocalDate newDate) {

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Vehicle v = em.find(Vehicle.class, vehicleId);

		if (v != null) {

			v.getRegistration().setExpiryDate(newDate);

			em.merge(v);
		}

		tx.commit();
	}

	// DELETE
	public void deleteVehicle(int id) {

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Vehicle v = em.find(Vehicle.class, id);

		if (v != null) {
			em.remove(v);
		}

		tx.commit();
	}
}