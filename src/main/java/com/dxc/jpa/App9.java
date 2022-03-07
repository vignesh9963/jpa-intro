package com.dxc.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App9 {

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


            Employee5 empThree = entityManager.find(Employee5.class, 3);

            System.out.println("\n****************************\n");
            System.out.println("Updating an employee's details:");

            empThree.setJob("Senior Vice President");
            empThree.setSalary(180000d);
            entityManager.persist(empThree);

            System.out.println("Details saved...");
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