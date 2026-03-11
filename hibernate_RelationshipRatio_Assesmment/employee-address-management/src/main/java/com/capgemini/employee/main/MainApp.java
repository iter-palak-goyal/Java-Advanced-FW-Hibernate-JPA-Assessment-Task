package com.capgemini.employee.main;

import java.util.Scanner;

import com.capgemini.employee.service.EmployeeService;

public class MainApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		EmployeeService service = new EmployeeService();

		System.out.println("Enter name:");
		String name = sc.next();

		System.out.println("Enter email:");
		String email = sc.next();

		System.out.println("Enter salary:");
		double salary = sc.nextDouble();

		System.out.println("Enter street:");
		String street = sc.next();

		System.out.println("Enter city:");
		String city = sc.next();

		System.out.println("Enter zipcode:");
		String zipcode = sc.next();

		service.addEmployee(name, email, salary, street, city, zipcode);

		sc.close();

	}

}