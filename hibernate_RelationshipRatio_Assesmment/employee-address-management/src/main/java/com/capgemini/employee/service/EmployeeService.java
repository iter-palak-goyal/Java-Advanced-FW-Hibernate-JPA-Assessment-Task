package com.capgemini.employee.service;

import com.capgemini.employee.dao.EmployeeDAO;
import com.capgemini.employee.entity.Address;
import com.capgemini.employee.entity.Employee;

public class EmployeeService {

	EmployeeDAO dao = new EmployeeDAO();

	public void addEmployee(String name, String email, double salary, String street, String city, String zipcode) {

		Address address = new Address(street, city, zipcode);

		Employee emp = new Employee(name, email, salary, address);

		dao.addEmployee(emp);

	}

}