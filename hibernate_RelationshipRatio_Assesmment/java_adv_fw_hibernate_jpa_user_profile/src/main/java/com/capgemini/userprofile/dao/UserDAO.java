package com.capgemini.userprofile.dao;

import java.time.LocalDate;

import com.capgemini.userprofile.entity.Profile;
import com.capgemini.userprofile.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("user-profile-unit");

	public void addUser(User user) {

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();

		System.out.println("User added successfully");
		display(user);

		em.close();
	}

	public void searchUser(int id) {

		EntityManager em = emf.createEntityManager();

		User user = em.find(User.class, id);

		if (user == null) {
			System.out.println("No user found");
		} else {
			display(user);
		}

		em.close();
	}

	public void updateEmail(int id, String newEmail) {

		EntityManager em = emf.createEntityManager();

		User user = em.find(User.class, id);

		if (user == null) {
			System.out.println("No user found");
		} else {

			em.getTransaction().begin();

			user.setEmail(newEmail);

			em.getTransaction().commit();

			System.out.println("Email updated successfully");
		}

		em.close();
	}

	public void updateProfile(int id, String phone, String gender, LocalDate dob) {

		EntityManager em = emf.createEntityManager();

		User user = em.find(User.class, id);

		if (user == null) {
			System.out.println("No user found");
		} else {

			em.getTransaction().begin();

			Profile profile = user.getProfile();
			profile.setPhone(phone);
			profile.setGender(gender);
			profile.setDob(dob);

			em.getTransaction().commit();

			System.out.println("Profile updated successfully");
		}

		em.close();
	}

	public void deleteUser(int id) {

		EntityManager em = emf.createEntityManager();

		User user = em.find(User.class, id);

		if (user == null) {
			System.out.println("No user found");
		} else {

			em.getTransaction().begin();

			em.remove(user);

			em.getTransaction().commit();

			System.out.println("User deleted successfully");
		}

		em.close();
	}

	private void display(User user) {

		System.out.println("ID: " + user.getId());
		System.out.println("Username: " + user.getUsername());
		System.out.println("Email: " + user.getEmail());

		System.out.println("Profile:");
		System.out.println("  Phone: " + user.getProfile().getPhone());
		System.out.println("  Gender: " + user.getProfile().getGender());
		System.out.println("  DOB: " + user.getProfile().getDob());
	}
}