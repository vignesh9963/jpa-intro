package com.dxc.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App8 {

    public static void main( String[] args )
    {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmployeeDBUnit");
        EntityManager entityManager = factory.createEntityManager();

        try {

            entityManager.getTransaction().begin();

            Employee5 firstEmployee = new Employee5("Peter1", "Holland",
                    "Manager", 120000d);

            Employee5 secondEmployee = new Employee5("Bruce", "Brenner",
                    "Analyst", 80000d);

            Employee5 thirdEmployee = new Employee5("Naomi", "Miller",
                    "Vice President", 160000d);

            entityManager.persist(firstEmployee);
            entityManager.persist(secondEmployee);
            entityManager.persist(thirdEmployee);


            List<Employee5> employeeList = entityManager
                    .createQuery("SELECT ed FROM Employee5 ed")
                    .getResultList();

            System.out.println("\n****************************\n");
            System.out.println("The employees in the EmployeeDetails table:");
            for(Employee5 emp: employeeList){
                System.out.println(emp);
            }
            System.out.println("\n****************************\5n");

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