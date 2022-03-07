package com.dxc.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;

//Defining a Composite Key Class and Implementing Composite Keys (using embeddedable annotations)


public class App5 {

    public static void main( String[] args )
    {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmployeeDBUnit");
        EntityManager entityManager = factory.createEntityManager();

        try {

            entityManager.getTransaction().begin();

            EmployeeEntry entryOne = new EmployeeEntry(1, LocalDate.now(), LocalTime.now());
            EmployeeEntry entryTwo = new EmployeeEntry(1, LocalDate.now().minusDays(1),
                    LocalTime.now());
            EmployeeEntry entryThree = new EmployeeEntry(2, LocalDate.now(), LocalTime.now());

            System.out.println("Saving down entry : " + entryOne.toString());
            System.out.println("Saving down entry : " + entryTwo.toString());
            System.out.println("Saving down entry : " + entryThree.toString());

            entityManager.persist(entryOne);
            entityManager.persist(entryTwo);
            entityManager.persist(entryThree);

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