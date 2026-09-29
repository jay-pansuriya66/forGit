package com.garments.dao;

import jakarta.enterprise.context.ApplicationScoped;

import Entity.Garmentmaster;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class GarmentsDAO {

    @PersistenceContext(unitName = "GarmentPU")
    private EntityManager em;

    public List<Garmentmaster> getGarments(String category, String priceRange) {

        String jpql = "SELECT g FROM Garmentmaster g "
                + "WHERE g.category = :category "
                + "AND g.stock > 0 ";

        if (priceRange.equals("500-1000")) {
            jpql += "AND g.price BETWEEN 500 AND 1000";
        } 
        else if (priceRange.equals("1001-1500")) {
            jpql += "AND g.price BETWEEN 1001 AND 1500";
        } 
        else if (priceRange.equals(">1500")) {
            jpql += "AND g.price > 1500";
        }

        return em.createQuery(jpql, Garmentmaster.class)
                .setParameter("category", category)
                .getResultList();
    }
}