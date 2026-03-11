package com.capgemini.product;

import java.util.List;
import jakarta.persistence.EntityManager;

public class ProductService {

	ProductDAO dao = new ProductDAO();

	public void display(Product p) {

		System.out.println("ID: " + p.getId());
		System.out.println("Name: " + p.getName());
		System.out.println("Category: " + p.getCategory());
		System.out.println("Price: " + p.getPrice());
		System.out.println("Quantity: " + p.getQuantity());
	}

	public void searchByCategory(EntityManager em, String category) {

		List<Product> list = dao.getProductsByCategory(em, category);

		if (list.isEmpty()) {
			System.out.println("No product found.");
			return;
		}

		for (Product p : list) {
			display(p);
			System.out.println();
		}
	}
}