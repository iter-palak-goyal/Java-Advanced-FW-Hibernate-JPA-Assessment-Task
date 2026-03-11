package com.capgemini.employee.dao;

import com.capgemini.employee.entity.Employee;
import com.capgemini.employee.util.JPAUtil;

import jakarta.persistence.EntityManager;

public class EmployeeDAO {

public void addEmployee(Employee employee) {

EntityManager em = JPAUtil.getEntityManager();

em.getTransaction().begin();
em.persist(employee);
em.getTransaction().commit();

System.out.println("Employee added successfully");

}

public Employee getEmployeeById(int id) {

EntityManager em = JPAUtil.getEntityManager();

return em.find(Employee.class,id);

}

public void updateSalary(int id,double salary) {

EntityManager em = JPAUtil.getEntityManager();

Employee emp = em.find(Employee.class,id);

if(emp==null){
System.out.println("No employee found.");
return;
}

em.getTransaction().begin();
emp.setSalary(salary);
em.getTransaction().commit();

System.out.println("Employee salary updated successfully");

}

public void deleteEmployee(int id){

EntityManager em = JPAUtil.getEntityManager();

Employee emp = em.find(Employee.class,id);

if(emp==null){
System.out.println("No employee found.");
return;
}

em.getTransaction().begin();
em.remove(emp);
em.getTransaction().commit();

System.out.println("Employee deleted successfully");

}

}