package com.dxc.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//Configuring Entity Classes Using JPA Annotations

public class App2 {

    public static void main( String[] args )
    {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmployeeDBUnit");
        EntityManager entityManager = factory.createEntityManager();

        try {

            entityManager.getTransaction().begin();

            Employee2 firstEmployee = new Employee2(1121, "Peter", "Holland",
                    "Manager", 120000d);

            Employee2 secondEmployee = new Employee2(1141,"Bruce", "Brenner",
                    "Analyst", 80000d);

            Employee2 thirdEmployee = new Employee2();
            thirdEmployee.setId(1123);

            entityManager.persist(firstEmployee);
            entityManager.persist(secondEmployee);
            entityManager.persist(thirdEmployee);

        }catch (Exception exception){

            System.err.println("An exception occurred:" + exception);
        }finally {

            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }

    }
}