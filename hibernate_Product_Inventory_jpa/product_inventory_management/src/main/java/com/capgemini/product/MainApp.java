package com.capgemini.product;

import java.util.Scanner;
import jakarta.persistence.*;

public class MainApp {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("product-unit");

        EntityManager em = emf.createEntityManager();

        ProductDAO dao = new ProductDAO();
        ProductService service = new ProductService();

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n===== PRODUCT INVENTORY SYSTEM =====");
            System.out.println("1 Add Product");
            System.out.println("2 Search Product");
            System.out.println("3 Update Product");
            System.out.println("4 Delete Product");
            System.out.println("5 Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Add Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Category: ");
                    String category = sc.nextLine();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Quantity: ");
                    int quantity = sc.nextInt();

                    Product p = new Product(name, category, price, quantity);

                    dao.addProduct(em, p);

                    System.out.println("Product added successfully.");

                    service.display(p);

                    break;

                case 2:

                    System.out.println("Search Product");

                    System.out.print("Category: ");
                    String cat = sc.nextLine();

                    service.searchByCategory(em, cat);

                    break;

                case 3:

                    System.out.println("Update Product");

                    System.out.print("ID: ");
                    int id = sc.nextInt();

                    System.out.print("New Price: ");
                    double newPrice = sc.nextDouble();

                    boolean updated = dao.updatePrice(em, id, newPrice);

                    if (updated) {

                        System.out.println("Product price updated successfully.");

                        Product prod = dao.getProductById(em, id);

                        service.display(prod);
                    }
                    else
                        System.out.println("No product found.");

                    break;

                case 4:

                    System.out.println("Delete Product");

                    System.out.print("ID: ");
                    int did = sc.nextInt();

                    boolean deleted = dao.deleteProduct(em, did);

                    if (deleted)
                        System.out.println("Product deleted successfully.");
                    else
                        System.out.println("No product found.");

                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
        em.close();
        emf.close();
    }
}