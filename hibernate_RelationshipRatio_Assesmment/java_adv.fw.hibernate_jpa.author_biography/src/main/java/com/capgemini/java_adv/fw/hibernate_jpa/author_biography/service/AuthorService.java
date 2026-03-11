package com.capgemini.java_adv.fw.hibernate_jpa.author_biography.service;

import java.time.LocalDate;

import com.capgemini.java_adv.fw.hibernate_jpa.author_biography.entity.Author;
import com.capgemini.java_adv.fw.hibernate_jpa.author_biography.entity.Biography;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AuthorService {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("AuthorDB");
	EntityManager em = emf.createEntityManager();

	// Add Author
	public void addAuthor(String name, String email, String summary, String birthPlace, LocalDate birthDate) {

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Author author = new Author();
		author.setName(name);
		author.setEmail(email);

		Biography bio = new Biography();
		bio.setSummary(summary);
		bio.setBirthPlace(birthPlace);
		bio.setBirthDate(birthDate);

		author.setBiography(bio);

		em.persist(author);

		tx.commit();

		System.out.println("Author added successfully");
		printAuthor(author);
	}

	// Search Author
	public void searchAuthor(int id) {

		Author author = em.find(Author.class, id);

		if (author != null) {
			printAuthor(author);
		} else {
			System.out.println("Author not found");
		}
	}

	// Update Biography
	public void updateBiography(int authorId, String summary, String birthPlace, LocalDate birthDate) {

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Author author = em.find(Author.class, authorId);

		if (author != null) {

			Biography bio = author.getBiography();

			bio.setSummary(summary);
			bio.setBirthPlace(birthPlace);
			bio.setBirthDate(birthDate);

			em.merge(author);

			System.out.println("Biography updated successfully");

		} else {
			System.out.println("Author not found");
		}

		tx.commit();
	}

	// Delete Author
	public void deleteAuthor(int id) {

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Author author = em.find(Author.class, id);

		if (author != null) {
			em.remove(author);
			System.out.println("Author deleted successfully");
		} else {
			System.out.println("Author not found");
		}

		tx.commit();
	}

	// Print Details
	private void printAuthor(Author author) {

		System.out.println("ID: " + author.getId());
		System.out.println("Name: " + author.getName());
		System.out.println("Email: " + author.getEmail());

		Biography bio = author.getBiography();

		System.out.println("Biography:");
		System.out.println("  Summary: " + bio.getSummary());
		System.out.println("  Birth Place: " + bio.getBirthPlace());
		System.out.println("  Birth Date: " + bio.getBirthDate());
	}
}