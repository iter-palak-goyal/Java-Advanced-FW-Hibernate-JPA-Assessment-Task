package com.capgemini.customer_wallet.main;

import java.util.Scanner;
import com.capgemini.customer_wallet.service.CustomerService;

public class App {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		CustomerService service = new CustomerService();

		while (true) {

			System.out.println("\n----- Customer Wallet System -----");
			System.out.println("1. Add Customer");
			System.out.println("2. Search Customer");
			System.out.println("3. Update Wallet Balance");
			System.out.println("4. Delete Customer");
			System.out.println("5. Exit");

			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				System.out.println("\nEnter Customer Details");

				System.out.print("Enter Name: ");
				String name = sc.next();

				System.out.print("Enter Email: ");
				String email = sc.next();

				System.out.print("Enter Wallet Balance: ");
				double balance = sc.nextDouble();

				System.out.print("Enter Currency: ");
				String currency = sc.next();

				service.addCustomer(name, email, balance, currency);
				break;

			case 2:
				System.out.print("\nEnter Customer ID to search: ");
				int id = sc.nextInt();

				service.searchCustomer(id);
				break;

			case 3:
				System.out.print("\nEnter Customer ID: ");
				int cid = sc.nextInt();

				System.out.print("Enter New Wallet Balance: ");
				double newBalance = sc.nextDouble();

				service.updateWallet(cid, newBalance);
				break;

			case 4:
				System.out.print("\nEnter Customer ID to delete: ");
				int did = sc.nextInt();

				service.deleteCustomer(did);
				break;

			case 5:
				System.out.println("Exiting program...");
				System.exit(0);

			default:
				System.out.println("Invalid choice. Try again.");
			}
		}
	}
}