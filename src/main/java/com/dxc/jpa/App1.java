package com.dxc.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


//using jpa configurations
public class App1 {

    public static void main( String[] args )
    {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmployeeDBUnit");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Employee1 firstEmployee1 = new Employee1(1123, "Rohit", "Sharma",
                "Manager", 120000);

        Employee1 secondEmployee1 = new Employee1(1143,"Mayank", "Agarwal",
                "Analyst", 90000);

        entityManager.persist(firstEmployee1);
        entityManager.persist(secondEmployee1);

        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();

    }
}