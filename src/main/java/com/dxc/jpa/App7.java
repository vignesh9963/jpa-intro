package com.dxc.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App7 {

    public static void main( String[] args )
    {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmployeeDBUnit");
        EntityManager entityManager = factory.createEntityManager();

        try {

            entityManager.getTransaction().begin();

            Employee5 firstEmployee = new Employee5("Peter", "Holland",
                    "Manager", 120000d);

            Employee5 secondEmployee = new Employee5("Bruce", "Brenner",
                    "Analyst", 80000d);

            Employee5 thirdEmployee = new Employee5("Naomi", "Miller",
                    "Vice President", 160000d);

            entityManager.persist(firstEmployee);
            entityManager.persist(secondEmployee);
            entityManager.persist(thirdEmployee);


            Employee5 empOne = entityManager.find(Employee5.class, 1);
            Employee5 empThree = entityManager.find(Employee5.class, 3);

            System.out.println("\n****************************\n");

            System.out.println("Details of empOne: " + empOne);
            System.out.println("Details of empThree: " + empThree);

            System.out.println("\n****************************\n");

        }
        catch (Exception exception){

            System.err.println("An exception occurred:" + exception);
        }
        finally {

            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }

    }
}