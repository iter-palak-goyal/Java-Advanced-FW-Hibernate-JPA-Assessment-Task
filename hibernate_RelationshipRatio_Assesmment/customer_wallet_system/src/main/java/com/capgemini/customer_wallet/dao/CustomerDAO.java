package com.capgemini.customer_wallet.dao;

import jakarta.persistence.*;
import com.capgemini.customer_wallet.entity.Customer;

public class CustomerDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CustomerDB");
    EntityManager em = emf.createEntityManager();

    public void addCustomer(Customer customer) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(customer);

        tx.commit();
    }

    public Customer findCustomer(int id) {

        return em.find(Customer.class, id);
    }

    public void updateWallet(Customer customer) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.merge(customer);

        tx.commit();
    }

    public void deleteCustomer(int id) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Customer c = em.find(Customer.class, id);

        if (c != null) {
            em.remove(c);
        }

        tx.commit();
    }
}
