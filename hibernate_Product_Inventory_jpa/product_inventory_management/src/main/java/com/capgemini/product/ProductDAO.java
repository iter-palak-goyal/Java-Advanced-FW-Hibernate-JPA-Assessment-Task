package com.capgemini.product;

import java.util.List;
import jakarta.persistence.*;

public class ProductDAO {

    public void addProduct(EntityManager em, Product p) {

        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

    public List<Product> getProductsByCategory(EntityManager em, String category) {

        TypedQuery<Product> query =
                em.createQuery(
                        "SELECT p FROM Product p WHERE p.category = :category",
                        Product.class);

        query.setParameter("category", category);

        return query.getResultList();
    }

    public Product getProductById(EntityManager em, int id) {
        return em.find(Product.class, id);
    }

    public boolean updatePrice(EntityManager em, int id, double price) {

        Product p = em.find(Product.class, id);

        if (p == null)
            return false;

        em.getTransaction().begin();
        p.setPrice(price);
        em.getTransaction().commit();

        return true;
    }

    public boolean deleteProduct(EntityManager em, int id) {

        Product p = em.find(Product.class, id);

        if (p == null)
            return false;

        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();

        return true;
    }
}