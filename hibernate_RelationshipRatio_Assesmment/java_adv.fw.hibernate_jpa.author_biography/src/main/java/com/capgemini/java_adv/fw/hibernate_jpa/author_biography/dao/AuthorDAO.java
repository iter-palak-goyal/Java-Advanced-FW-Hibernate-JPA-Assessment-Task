package com.capgemini.java_adv.fw.hibernate_jpa.author_biography.dao;

import jakarta.persistence.*;
import com.capgemini.java_adv.fw.hibernate_jpa.author_biography.entity.*;

public class AuthorDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("AuthorDB");
	EntityManager em = emf.createEntityManager();

	public void addAuthor(Author author) {

		EntityTransaction tx = em.getTransaction();

		tx.begin();
		em.persist(author);
		tx.commit();

	}

	public Author findAuthor(int id) {

		return em.find(Author.class, id);

	}

	public void deleteAuthor(int id) {

		EntityTransaction tx = em.getTransaction();

		tx.begin();
		Author author = em.find(Author.class, id);

		if (author != null) {
			em.remove(author);
		}

		tx.commit();
	}

}