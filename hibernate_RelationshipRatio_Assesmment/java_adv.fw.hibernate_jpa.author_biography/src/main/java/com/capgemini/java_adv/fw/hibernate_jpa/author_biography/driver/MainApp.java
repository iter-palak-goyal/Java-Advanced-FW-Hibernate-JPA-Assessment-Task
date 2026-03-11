package com.capgemini.java_adv.fw.hibernate_jpa.author_biography.driver;

import java.time.LocalDate;

import com.capgemini.java_adv.fw.hibernate_jpa.author_biography.dao.AuthorDAO;
import com.capgemini.java_adv.fw.hibernate_jpa.author_biography.entity.*;

public class MainApp {

	public static void main(String[] args) {

		Author author = new Author();
		author.setName("JK Rowling");
		author.setEmail("jk@example.com");

		Biography bio = new Biography();
		bio.setSummary("Famous author of Harry Potter");
		bio.setBirthPlace("Yate");
		bio.setBirthDate(LocalDate.parse("1965-07-31"));

		author.setBiography(bio);

		AuthorDAO dao = new AuthorDAO();

		dao.addAuthor(author);

		System.out.println("Author added successfully");

	}

}